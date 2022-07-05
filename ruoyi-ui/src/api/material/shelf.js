import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listShelf(query) {
  return request({
    url: '/material/shelf/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getShelf(id) {
  return request({
    url: '/material/shelf/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addShelf(data) {
  return request({
    url: '/material/shelf',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateShelf(data) {
  return request({
    url: '/material/shelf',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delShelf(id) {
  return request({
    url: '/material/shelf/' + id,
    method: 'delete'
  })
}
