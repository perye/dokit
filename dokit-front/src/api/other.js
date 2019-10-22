import request from '@/utils/request'
// 知识图谱
export function searchKnowledge(data) {
  console.log(data)
  return request({
    url:"api/knowledge/search",
    method: 'post',
    data
  })
}
