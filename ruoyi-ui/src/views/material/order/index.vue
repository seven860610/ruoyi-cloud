<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="入库时间" prop="instockTime">
        <el-date-picker
          v-model="dateRange"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="选择仓库" prop="stock">
        <el-select v-model="queryParams.stock" placeholder="请选择仓库" clearable :style="{width: '100%'}">
          <el-option v-for="item in stockList"
            :key="item.id"
            :label="item.stockName"
            :value="item.stockName">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="审核人" prop="reviewer">
        <el-input
          v-model="queryParams.reviewer"
          placeholder="请输入审核人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审核时间" prop="reviewTime">
        <el-date-picker clearable
          v-model="queryParams.reviewTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择审核时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="操作员" prop="operator">
        <el-input
          v-model="queryParams.operator"
          placeholder="请输入操作员"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['material:order:edit']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['material:order:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['material:order:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['material:order:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="orderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="入库单号" align="center" prop="instockNo" />
      <el-table-column label="入库仓库" align="center" prop="stock" />
      <el-table-column label="入库时间" align="center" prop="instockTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.instockTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="入库总数" align="center" prop="pennum" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="审核人" align="center" prop="reviewer" />
      <el-table-column label="审核时间" align="center" prop="reviewTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.reviewTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作员" align="center" prop="operator" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['material:order:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['material:order:remove']"
          >删除</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-search"
            @click="getDetailList(scope.row.instockNo)"
          >查看明细</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改【请填写功能名称】对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="入库时间" prop="instockTime">
          <el-date-picker clearable
            v-model="form.instockTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择入库时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="选择仓库" prop="stock">
          <el-select v-model="form.stock" placeholder="请选择仓库" clearable :style="{width: '100%'}">
            <el-option v-for="index in stockListEdit"
              :key="index.id"
              :label="index.stockName"
              :value="index.stockName">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="入库总数" prop="pennum">
          <el-input v-model="form.pennum" placeholder="请输入入库总数" />
        </el-form-item>
        <el-form-item label="审核人" prop="reviewer">
          <el-input v-model="form.reviewer" placeholder="请输入审核人" />
        </el-form-item>
        <el-form-item label="审核时间" prop="reviewTime">
          <el-date-picker clearable
            v-model="form.reviewTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择审核时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="操作员" prop="operator">
          <el-input v-model="form.operator" placeholder="请输入操作员" :disabled = "true" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <el-divider style="color: blue"></el-divider>
    <el-dialog :title="detailTitle" :visible.sync="detailOpen" width="80%" append-to-body>
      <el-table v-loading="loadingDetail" :data="detailList">
        <el-table-column label="ID" align="center" prop="id" />
        <el-table-column label="入库单号" align="center" prop="instockNo" />
        <el-table-column label="货架编号" align="center" prop="shelfNo" />
        <el-table-column label="物资编号" align="center" prop="materialNo" />
        <el-table-column label="物资名称" align="center" prop="materialName" />
        <el-table-column label="类型" align="center" prop="materialType" />
        <el-table-column label="规格" align="center" prop="materialSpecs" />
        <el-table-column label="数量" align="center" prop="nums" />
      </el-table>
      <pagination
        v-show="total>0"
        :total="DetailTotal"
        :page.sync="queryDetailParams.detailPageNum"
        :limit.sync="queryDetailParams.detailPageSize"
        @pagination="getDetailList"
      />
    </el-dialog>
  </div>
</template>

<script>
import { listOrder, getOrder, delOrder, addOrder, updateOrder } from "@/api/material/order";
import { listDetail} from "@/api/material/detail";
import { listInfo} from "@/api/material/stock";
import { getUserProfile } from "@/api/system/user";

export default {
  name: "Order",
  data() {
    return {
      //默认新增用户
      user: {},
      // 遮罩层
      loading: true,
      //明细表遮罩层
      loadingDetail: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      //明细总条数
      DetailTotal: 0,
      // 入库单表格数据
      orderList: [],
      // 入库单明细表格数据
      detailList: [],
      // 日期范围
      dateRange: [],
      //仓库列表
      stockList: [],
      //编辑框仓库列表
      stockListEdit: [],
      // 弹出层标题
      title: "",
      detailTitle: "",
      // 是否显示弹出层
      open: false,
      detailOpen: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        instockTime: null,
        stock: null,
        status: null,
        reviewer: null,
        reviewTime: null,
        operator: null,
      },
      queryDetailParams: {
        detailPageNum: 1,
        detailPageSize: 10,
        instockNo: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
    this.getStockList();
    this.getUser();
  },
  methods: {
    //默取登陆用户
    getUser() {
      getUserProfile().then(response => {
        this.user = response.data;
      });
    },

    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true;
      listOrder(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
        this.orderList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询入库单明细列表 */
    getDetailList(instockNo) {
      if((typeof instockNo=='string')&&instockNo.constructor==String){
        this.queryDetailParams.instockNo = instockNo
        this.loadingDetail = true;
        this.detailTitle = "查询入库单明细";
        listDetail(this.queryDetailParams).then(response => {
          this.detailList = response.rows;
          this.DetailTotal = response.total;
          this.loadingDetail = false;
          this.detailOpen = true;
        });
      }
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        instockNo: null,
        instockTime: null,
        pennum: null,
        status: "0",
        reviewer: null,
        reviewTime: null,
        operator: null,
        createTime: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.dateRange = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.instockNo)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      //this.reset();
      //this.open = true;
      //this.form.operator = this.user.nickName;
      //this.title = "添加物资入库单";
      this.$router.replace('/material/instore/edit')
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const instockNo = row.instockNo || this.ids
      getOrder(instockNo).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改物资入库单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.instockNo != null) {
            updateOrder(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOrder(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const instockNos = row.instockNo || this.ids;
      this.$modal.confirm('是否确认删除物资入库单编号为"' + instockNos + '"的数据项？').then(function() {
        return delOrder(instockNos);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('material/order/export', {
        ...this.queryParams
      }, `order_${new Date().getTime()}.xlsx`)
    },
    getStockList(){
      listInfo().then(response => {
        this.stockList = response.rows;
        this.stockListEdit = response.rows;
      });
    }
  }
};
</script>

