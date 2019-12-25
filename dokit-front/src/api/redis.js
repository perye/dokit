import request from '@/utils/request'

export function add(data) {
  return request({
    url: 'api/redis',
    method: 'post',
    data
  })
}

export function del(keys) {
  return request({
    url: 'api/redis',
    method: 'delete',
    data: keys
  })
}

export function edit(data) {
  return request({
    url: 'api/redis',
    method: 'put',
    data
  })
}

export default { del }
