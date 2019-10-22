import request from '@/utils/request'
// 知识图谱
export function searchKnowledge(data) {
  return request({
    url:"api/knowledge/search",
    method: 'post',
    data
  })
}
//热门查询
export function hotSearch() {
  return request({
    url:"api/knowledge/hot",
    method: 'get'
  })
}

//最新查询
export function newSearch() {
  return request({
    url:"api/knowledge/new",
    method: 'get'
  })
}

