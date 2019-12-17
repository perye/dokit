import request from '@/utils/request'

export function add(data) {
  return request({
    url: 'api/captcha',
    method: 'post',
    data
  })
}

export function delAll(ids) {
  return request({
    url: 'api/captcha/',
    method: 'delete',
    data: ids
  })
}

export function del(id) {
  return request({
    url: 'api/captcha/' + id,
    method: 'delete'
  })
}

export function edit(data) {
  return request({
    url: 'api/captcha',
    method: 'put',
    data
  })
}

export default { add, edit, del, delAll }
