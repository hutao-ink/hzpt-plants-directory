# hzpt-plants-directory
杭科院动植物名录小程序

**简介**:


**HOST**:localhost:8181


**联系人**:xx@qq.com


**Version**:1.0


**接口路径**:/v2/api-docs?group=2.X版本


[TOC]






# animals-controller


## 通过名字模糊查询


**接口地址**:`/directory/animals/fuzzyQuery`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| name     | name     | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```


# branch-controller


## 获取科目总数


**接口地址**:`/directory/branch/branchCount`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```


## 添加科目


**接口地址**:`/directory/branch/insertBranch`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| branch   | branch   | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 201    | Created      |        |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```


## 查询所有科目


**接口地址**:`/directory/branch/searchBranch`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```


# carousel-controller


## 添加轮播图


**接口地址**:`/directory/carousel/insertCarousel`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称       | 参数说明       | 请求类型 | 是否必须 | 数据类型 | schema |
| -------------- | -------------- | -------- | -------- | -------- | ------ |
| carouselUrl    | carouselUrl    | query    | true     | string   |        |
| biologicalId   | biologicalId   | query    | false    | string   |        |
| biologicalName | biologicalName | query    | false    | string   |        |


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 201    | Created      |        |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```


## 获取所有轮播图


**接口地址**:`/directory/carousel/queryCarousel`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```


# genus-controller


## 获取属总数


**接口地址**:`/directory/genus/genusCount`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```


## 添加属目


**接口地址**:`/directory/genus/insertGenus`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| genus    | genus    | query    | true     | string   |        |
| branchId | branchId | query    | false    | string   |        |


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 201    | Created      |        |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```


## 查询所有属目


**接口地址**:`/directory/genus/searchGenus`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


## 通过科类id查找所有属类


**接口地址**:`/directory/genus/searchGenusByBranchId`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| id       | id       | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


# plants-controller


## 通过名字模糊查询


**接口地址**:`/directory/plants/fuzzyQuery`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| name     | name     | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```


## 添加植物


**接口地址**:`/directory/plants/insertPlant`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称    | 参数说明    | 请求类型 | 是否必须 | 数据类型 | schema |
| ----------- | ----------- | -------- | -------- | -------- | ------ |
| plantName   | plantName   | query    | true     | string   |        |
| address     | address     | query    | false    | string   |        |
| alias       | alias       | query    | false    | string   |        |
| description | description | query    | false    | string   |        |
| imagesUrl   | imagesUrl   | query    | false    | string   |        |
| speciesId   | speciesId   | query    | false    | string   |        |


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 201    | Created      |        |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```


## 获取植物总数


**接口地址**:`/directory/plants/plantsCount`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


## 通过植物id查询植物所有信息


**接口地址**:`/directory/plants/queryPlantById`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| id       | id       | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```


## 查询所有植物


**接口地址**:`/directory/plants/searchPlants`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


## 通过种类id查找所有植物


**接口地址**:`/directory/plants/searchPlantsByGenusId`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| id       | id       | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```


# species-controller


## 获取种总数


**接口地址**:`/directory/species/genusCount`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```


## 添加种类


**接口地址**:`/directory/species/insertSpecies`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| species  | species  | query    | true     | string   |        |
| genusId  | genusId  | query    | false    | string   |        |


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 201    | Created      |        |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```


## 查询所有种类


**接口地址**:`/directory/species/searchSpecies`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```


## 通过属类id查找所有种类


**接口地址**:`/directory/species/searchSpeciesByGenusId`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| id       | id       | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```


# user-controller


## 用户搜索动植物


**接口地址**:`/directory/user/fuzzyQuery`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| name     | name     | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称  | 参数说明 | 类型              | schema            |
| --------- | -------- | ----------------- | ----------------- |
| details   |          | string            |                   |
| info      |          | string            |                   |
| message   |          | object            |                   |
| path      |          | string            |                   |
| status    |          | integer(int32)    | integer(int32)    |
| timestamp |          | string(date-time) | string(date-time) |


**响应示例**:

```javascript
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```
