import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listOrder(query) {
  return request({
    url: '/material/order/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getOrder(instockNo) {
  return request({
    url: '/material/order/' + instockNo,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addOrder(data) {
  return request({
    url: '/material/order/add',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateOrder(data) {
  return request({
    url: '/material/order/update',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delOrder(instockNo) {
  return request({
    url: '/material/order/' + instockNo,
    method: 'delete'
  })
}

//创建入库单号
export function getInstockNo(){
  return request({
    url: "/material/order/createInstockNo",
    method: 'get'
  })
}
