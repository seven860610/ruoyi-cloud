<template>
  <div class="app-container">
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-edit"
          size="default"
          @click="orderSave"
          v-hasPermi="['material:order:add']"
        >保存</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon"
          size="default"
          @click="cancel"
          v-hasPermi="['material:order:add']"
        >取消</el-button>
      </el-col>
    </el-row>
    <el-form ref="form" :model="form" :inline="true" :rules="rules" label-width="80px">
      <el-form-item label="入库单号" prop="instockNo">
        <el-input v-model="form.instockNo" placeholder="请输入入库单号" :disabled = "true" />
      </el-form-item>
      <el-form-item label="入库时间" prop="instockTime">
        <el-date-picker clearable
          v-model="form.instockTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择入库时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="选择仓库" prop="stock">
        <el-select v-model="form.stock" placeholder="请选择仓库" @change='selectChanged' clearable :style="{width: '100%'}">
          <el-option v-for="index in stockList"
            :key="index.stockName"
            :label="index.stockName"
            :value="index.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="操作员" prop="operator">
        <el-input v-model="form.operator" placeholder="请输入操作员" :disabled = "true" />
      </el-form-item>
    </el-form>
    <el-divider style="color: blue"></el-divider>
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="addLine"
          v-hasPermi="['material:detail:edit']"
        >添加明细</el-button>
      </el-col>
    </el-row>
    <div id="app">
        <el-form  ref="detailForm" :model="detailForm" :rules="detailRules" auto-complete="on">
          <el-table ref="table-input"  :data="detailForm.detailList" @selection-change="handleSelectionChange">
            <el-table-column label="入库单号" show-overflow-tooltip>
              <template slot-scope="scope">
                <el-form-item :prop="'detailList.'+scope.$index+'.instockNo'" :rules="detailRules.instockNo" class="all">
                  <el-input v-model="scope.row.instockNo" placeholder="请输入" :disabled="true" clearable @focus="$refs.detailForm.clearValidate(`detailList.${scope.$index}.instockNo`)"></el-input>
                </el-form-item>
              </template>
            </el-table-column>
            <el-table-column label="货架编号" show-overflow-tooltip>
              <template slot-scope="scope">
                <el-form-item :prop="'detailList.'+scope.$index+'.shelfNo'" :rules="detailRules.shelfNo" class="all" :style="{width: '80%'}">
                  <el-select v-model="scope.row.shelfNo"   placeholder="请选择货架编号" clearable  >
                    <el-option v-for="item in shelfList"
                      :key="item.id"
                      :label="item.shelfNo"
                      :value="item.shelfNo">
                    </el-option>
                  </el-select>
                </el-form-item>
              </template>
            </el-table-column>
            <el-table-column label="物资编号" show-overflow-tooltip :style="{width: '100%'}">
              <template slot-scope="scope">
                <el-form-item :prop="'detailList.'+scope.$index+'.materialNo'" :rules="detailRules.materialNo" class="all">
                  <el-input v-model="scope.row.materialNo" placeholder="请输入" clearable @focus="$refs.detailForm.clearValidate(`detailList.${scope.$index}.materialNo`)"></el-input>
                </el-form-item>
              </template>
            </el-table-column>
            <el-table-column label="物资名称" show-overflow-tooltip>
              <template slot-scope="scope">
                <el-form-item :prop="'detailList.'+scope.$index+'.materialName'" :rules="detailRules.materialName" class="all">
                  <el-input v-model="scope.row.materialName" placeholder="请输入" clearable @focus="$refs.detailForm.clearValidate(`detailList.${scope.$index}.materialName`)"></el-input>
                </el-form-item>
              </template>
            </el-table-column>
            <el-table-column label="类型" show-overflow-tooltip>
              <template slot-scope="scope">
                <el-form-item :prop="'detailList.'+scope.$index+'.materialType'" :rules="detailRules.materialType" class="all">
                  <el-input v-model="scope.row.materialType" placeholder="请输入" clearable @focus="$refs.detailForm.clearValidate(`detailList.${scope.$index}.materialType`)"></el-input>
                </el-form-item>
              </template>
            </el-table-column>
            <el-table-column label="规格" show-overflow-tooltip>
              <template slot-scope="scope">
                <el-form-item :prop="'detailList.'+scope.$index+'.materialSpecs'" :rules="detailRules.materialSpecs" class="all">
                  <el-input v-model="scope.row.materialSpecs" placeholder="请输入" clearable @focus="$refs.detailForm.clearValidate(`detailList.${scope.$index}.materialSpecs`)"></el-input>
                </el-form-item>
              </template>
            </el-table-column>
            <el-table-column label="数量" show-overflow-tooltip>
              <template slot-scope="scope">
                <el-form-item :prop="'detailList.'+scope.$index+'.nums'" :rules="detailRules.nums" class="all">
                  <el-input v-model="scope.row.nums" placeholder="请输入" clearable @focus="$refs.detailForm.clearValidate(`detailList.${scope.$index}.nums`)" :disabled = "true"></el-input>
                </el-form-item>
              </template>
            </el-table-column>
            <el-table-column prop="" label="操作">
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  type="text"
                  icon="el-icon-delete"
                  @click="delDetailCol(scope.row,scope.$index)"
                >删除</el-button>
                <el-button
                  size="mini"
                  type="text"
                  icon="el-icon-refresh"
                  @click="createMateriaNo(scope.row)"
                >生成物资编号</el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-form>
      </div>
  </div>
</template>
<script>
import { listOrder, getOrder, delOrder, addOrder, updateOrder,getInstockNo } from "@/api/material/order";
import { listDetail,getDetail,addDetail,updateDetail,delDetail} from "@/api/material/detail";
import { listInfo} from "@/api/material/stock";
import { getUserProfile } from "@/api/system/user";
import { listShelf} from "@/api/material/shelf";


export default {
  name: "Order-detail",
  data() {
    return {
      instockNo: null,
      //默认新增用户
      user: {},
      //明细表遮罩层
      loadingDetail: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      //仓库列表
      stockList: [],
      //货架列表
      shelfList: [],
      //明细列表下标
      index: 0,
      // 表单参数
      form: {},
      //明细表单参数
      detailForm: {
      // 入库单明细表格数据
      detailList: [],
      },
      //货架查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        stockId: null
      },
      // 表单校验
      rules: {
        instockTime: [
          { required: true, message: "请选择入库时间", trigger: "blur" }
        ],
        stock: [
          { required: true, message: "请选择入库仓库", trigger: "blur" }
        ]
      },
      //明细表表单校验
      detailRules: {
          instockNo: [
            { required: true, message: "请选择货架编号", trigger: "blur" }
          ],
          shelfNo: [
            { required: true, message: "请选择货架编号", trigger: "blur" }
          ],
          materialNo: [
            { required: true, message: "请录入物资编号", trigger: "blur" }
          ],
          materialName: [
            { required: true, message: "请选择物资", trigger: "blur" }
          ],
          materialType: [
            { required: true, message: "请选择物资", trigger: "blur" }
          ],
          materialSpecs: [
            { required: true, message: "请选择物资", trigger: "blur" }
          ],
      }
    };
  },
  created() {
    this.reset();
    this.getStockList();
    this.getUser();
    this.createInstockNo();
  },
  methods: {
      cancel() {
        // 调用全局挂载的方法
        this.$store.dispatch('tagsView/delView', this.$route)
        // 返回上一步路由
        this.$router.go(-1)
      },
      //表单重置
      reset() {
        this.form = {
          instockNo: null,
          instockTime: null,
          stock: null,
          operator: null,
          createTime: null,
          updateTime: null
        };
        this.resetForm("form");
        this.resetForm("detailForm");
      },
      //自动生成物资编号
      createMateriaNo(row){
        alert(row.instockNo);
      },
      //仓库下拉框值改变事件
      selectChanged(value){
          this.resetForm("detailForm");
          this.getShelfList();
      },

      //获取货架列表
      getShelfList(){
        this.shelfList = [];
        this.queryParams.stockId = this.form.stock;
        listShelf(this.queryParams).then(response => {
          this.shelfList = response.rows;
        });
      },

      //默取登陆用户
     getUser() {
       getUserProfile().then(response => {
         this.form.operator = response.data.nickName;
       });
     },
     //获取入库单号
     createInstockNo(){
        getInstockNo().then(response =>{
          this.form.instockNo = response.data.instockNo;
          this.instockNo =  response.data.instockNo;
        });
     },
     //获取仓库列表
     getStockList(){
       listInfo().then(response => {
         this.stockList = response.rows;
       });
     },
    // 增加一个空行, 用于录入或显示第一行
    addLine() {
      if(this.form.instockTime === null){
        this.$toast.top('请选择日期！');
        return false;
      }
      if(this.form.stock === null){
        this.$toast.top('请选择仓库！');
        return false;
      }
      const newLine = {
        id: "",
        instockNo: this.instockNo,
        shelfNo: "",
        materialNo: "",
        materialName: "",
        materialType: "",
        materialSpecs: "",
        nums: 1
      };
      this.index++;
      this.detailForm.detailList.push(newLine);
      this.getShelfList();

    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.instockNo)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 保存入库单 */
    orderSave() {
      let form=new Promise((resolve,reject)=>{
        this.$refs["form"].validate((valid) => {
          if(valid){
            resolve();
          }
          else{
            return false;
          }

        });
      });
      let detailForm=new Promise((resolve,reject)=>{
        if (this.detailForm.detailList.length<1) {
            this.$toast.top('请添加明细！');
            return false
        }
        this.$refs.detailForm.validate((valid) => {
          if(valid){
            resolve();
          }
          else{
            return false;
          }
        });
      });
      Promise.all([form,detailForm]).then(()=>{
         this.$confirm("您确定【提交】？", "提示", {
           confirmButtonText: "确定",
           cancelButtonText: "取消",
           type: "warning"
         }).then(() => {
           console.log("校验通过")
         })
      });
    },
    /** 删除按钮操作 */
    delDetailCol(data, index) {
      this.detailForm.detailList.splice(index, 1);
      this.$modal.msgSuccess("删除成功！");
    }
  }
};
</script>
