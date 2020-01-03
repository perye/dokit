import request from '@/utils/request'

export function get() {
  return request({
    url: 'api/monitor/server',
    method: 'get'
  })
}
