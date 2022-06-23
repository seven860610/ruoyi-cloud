import request from '@/utils/request'
/*export function policy () {
  return new Promise((resolve) => {
    http({
      url: service.adornUrl('/thirthpart/oss/getPolicy'),
      method: 'get',
      params: service.adornParams({}),
    }).then(({ data }) => {
      resolve(data)
    })
  })
}*/
// 查询【请填写功能名称】列表
export function policy() {
  return request({
    url: '/thirthpart/oss/getPolicy',
    method: 'get',
    params: request.adornParams({})
  })
}

