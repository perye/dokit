import request from '@/utils/request'

export function add(data) {
  return request({
    url: 'api/test',
    method: 'post',
    data
  })
}

export function del(id) {
  return request({
    url: 'api/test/' + id,
    method: 'delete'
  })
}

export function edit(data) {
  return request({
    url: 'api/test',
    method: 'put',
    data
  })
}

export function downloadTest(params) {
  return request({
    url: 'api/test/download',
    method: 'get',
    params,
    responseType: 'blob'
  })
}
