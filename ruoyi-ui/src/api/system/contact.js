import request from '@/utils/request'

// 查询校外人员信息列表
export function listContact(query) {
  return request({
    url: '/system/contact/list',
    method: 'get',
    params: query
  })
}

// 查询校外人员信息详细
export function getContact(contactId) {
  return request({
    url: '/system/contact/' + contactId,
    method: 'get'
  })
}

// 新增校外人员信息
export function addContact(data) {
  return request({
    url: '/system/contact',
    method: 'post',
    data: data
  })
}

// 修改校外人员信息
export function updateContact(data) {
  return request({
    url: '/system/contact',
    method: 'put',
    data: data
  })
}

// 删除校外人员信息
export function delContact(contactId) {
  return request({
    url: '/system/contact/' + contactId,
    method: 'delete'
  })
}

// 导出校外人员信息
export function exportContact(query) {
  return request({
    url: '/system/contact/export',
    method: 'get',
    params: query
  })
} 