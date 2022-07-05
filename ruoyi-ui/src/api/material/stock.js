import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listInfo(query) {
  return request({
    url: '/material/stock/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getInfo(id) {
  return request({
    url: '/material/stock/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addInfo(data) {
  return request({
    url: '/material/stock/add',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateInfo(data) {
  return request({
    url: '/material/stock',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delInfo(id) {
  return request({
    url: '/material/stock/' + id,
    method: 'delete'
  })
}
