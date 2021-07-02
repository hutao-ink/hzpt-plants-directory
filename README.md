# 校园动植物名录小程序开发文档

**联系人**: 489516067@qq.com

**服务Url**: https://hutao.ink/app/directory

**小程序二维码（简版）**

![](https://img-youpai.weixiaoi.com/tu/2021/0702/1625234299210702.jpg)

---

[TOC]

## 数据库设计

### 1.植物表(tbl_plants)

|   字段名    |     类型     | 是否为空 |    备注    |
| :---------: | :----------: | :------: | :--------: |
|     id      | varchar(50)  | NOT NULL | 序号(UUID) |
|  plantName  | varchar(50)  |          |  植物名称  |
|    alias    | varchar(255) |          |    别名    |
|  imagesUrl  | varchar(255) |          |  图片地址  |
| description |   int(32)    |          |  描述信息  |
|  speciesId  | varchar(50)  |          |   种类id   |
|   address   |   longtext   |          |    地址    |
|   remarks   | varchar(50)  |          |    备注    |
|   deleted   |   tinyint    |          |  逻辑删除  |
| createTime  |   datetime   |          |  创建时间  |



### 2.动物表(tbl_animals)

|   字段名    |     类型     | 是否为空 |    备注    |
| :---------: | :----------: | :------: | :--------: |
|     id      | varchar(50)  | NOT NULL | 序号(UUID) |
| animalName  | varchar(50)  |          |  动物名称  |
|    alias    | varchar(255) |          |    别名    |
|  imagesUrl  | varchar(255) |          |  图片地址  |
| description |   int(32)    |          |  描述信息  |
|  speciesId  | varchar(50)  |          |   种类id   |
|   address   |   longtext   |          |    地址    |
|   remarks   | varchar(50)  |          |    备注    |
|   deleted   |   tinyint    |          |  逻辑删除  |
| createTime  |   datetime   |          |  创建时间  |

### 3.科目表(tbl_branch)

|   字段名   |     类型     | 是否为空 |    备注    |
| :--------: | :----------: | :------: | :--------: |
|     id     | varchar(50)  | NOT NULL | 序号(UUID) |
|   branch   | varchar(50)  |          |    科目    |
| imagesUrl  | varchar(255) |          |  图片地址  |
|    type    |   tinyint    |          |  科目类型  |
| createTime |   datetime   |          |  创建时间  |

### 4.属目表(tbl_genus)

|   字段名   |    类型     | 是否为空 |    备注    |
| :--------: | :---------: | :------: | :--------: |
|     id     | varchar(50) | NOT NULL | 序号(UUID) |
|   genus    | varchar(50) |          |    属目    |
|  branchId  | varchar(50) |          |   科目id   |
| createTime |  datetime   |          |  创建时间  |

### 5.种类表(tbl_species)

|   字段名   |     类型     | 是否为空 |    备注    |
| :--------: | :----------: | :------: | :--------: |
|     id     | varchar(50)  | NOT NULL | 序号(UUID) |
|  species   | varchar(50)  |          |    种名    |
| imagesUrl  | varchar(255) |          |  图片地址  |
|  genusId   | varchar(50)  |          |   属类id   |
| createTime |   datetime   |          |  创建时间  |

### 6.用户表(tbl_user)

|   字段名   |     类型     | 是否为空 |     备注     |
| :--------: | :----------: | :------: | :----------: |
|     id     | varchar(50)  | NOT NULL |  序号(UUID)  |
|  nickName  | varchar(50)  |          |   用户昵称   |
| imagesUrl  | varchar(255) |          | 头像图片地址 |
|   openId   | varchar(50)  |          |   登录凭证   |
|    city    | varchar(50)  |          |     城市     |
|  province  | varchar(50)  |          |     省份     |
|  country   | varchar(50)  |          |     国家     |
|   gender   |  tinyint(1)  |          |     性别     |
| createTime |   datetime   |          |   创建时间   |

-- ----------------------------

### 7.留言表(tbl_message)

|   字段名    |     类型     | 是否为空 |     备注     |
| :---------: | :----------: | :------: | :----------: |
|     id      | varchar(50)  | NOT NULL |  序号(UUID)  |
|   userId    | varchar(50)  |          |    用户id    |
|  imagesUrl  | varchar(255) |          | 留言图片地址 |
| userMessage | varchar(50)  |          |   留言信息   |
| createTime  |   datetime   |          |   创建时间   |

### 8.轮播图表(tbl_carousel)

|     字段名     |    类型     | 是否为空 |    备注    |
| :------------: | :---------: | :------: | :--------: |
|       id       | varchar(50) | NOT NULL | 序号(UUID) |
|  carouselUrl   | varchar(50) |          | 轮播图地址 |
| biologicalName | varchar(50) |          |  生物名称  |
|  biologicalId  | varchar(50) |          |   生物id   |
|   createTime   |  datetime   |          |  创建时间  |

## 接口文档


### animals-controller


#### 获取动物总数


**接口地址**:`/directory/animals/animalsCount`


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


#### 通过名字模糊查询


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


#### 通过动物id获取动物所有信息


**接口地址**:`/directory/animals/queryAnimalById`


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


#### 查询所有动物


**接口地址**:`/directory/animals/searchAnimals`


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


#### 通过种类id查找所有动物


**接口地址**:`/directory/animals/searchAnimalsByGenusId`


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


### branch-controller


#### 获取科目总数


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


#### 通过科名获取科信息


**接口地址**:`/directory/branch/getBranchInfo`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


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


#### 添加科目


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


#### 查询动物科目


**接口地址**:`/directory/branch/searchAnimalBranch`


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


#### 查询所有科目


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


#### 查询植物科目


**接口地址**:`/directory/branch/searchPlantBranch`


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


### carousel-controller


#### 添加轮播图


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


#### 获取所有轮播图


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


### genus-controller


#### 获取属总数


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


#### 通过属名获取属信息


**接口地址**:`/directory/genus/getGenusInfo`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| genus    | genus    | query    | true     | string   |        |


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


#### 添加属目


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


#### 查询所有属目


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


#### 通过科类id查找所有属类


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
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```


### message-controller


#### 展示所有用户留言


**接口地址**:`/directory/message/getAllMessages`


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


### plants-controller


#### 分页模糊查询


**接口地址**:`/directory/plants/fuzzyQuery`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称    | 参数说明    | 请求类型 | 是否必须 | 数据类型       | schema |
| ----------- | ----------- | -------- | -------- | -------------- | ------ |
| name        | name        | query    | true     | string         |        |
| currentPage | currentPage | query    | false    | integer(int32) |        |


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


#### 添加植物


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


#### 获取植物总数


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


#### 通过生物id查询植物所有信息


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


#### 查询所有植物


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
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```


#### 通过种类id查找所有植物


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


### species-controller


#### 获取种总数


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


#### 种类插入图片


**接口地址**:`/directory/species/insertImageByName`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| imageUrl | imageUrl | query    | false    | string   |        |
| name     | name     | query    | false    | string   |        |


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


#### 添加种类


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


#### 查询所有种类


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


#### 通过属类id查找所有种类


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


#### 获取所有图片为空的种类


**接口地址**:`/directory/species/searchSpeciesWhereImageNull`


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


### user-controller


#### 用户搜索动植物分页


**接口地址**:`/directory/user/fuzzyQuery`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称    | 参数说明    | 请求类型 | 是否必须 | 数据类型       | schema |
| ----------- | ----------- | -------- | -------- | -------------- | ------ |
| name        | name        | query    | true     | string         |        |
| currentPage | currentPage | query    | false    | integer(int32) |        |


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


#### 获取所有用户留言信息


**接口地址**:`/directory/user/getAllMessage`


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


#### 获取最新的二十条添加记录


**接口地址**:`/directory/user/getNewestTwentyBiological`


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


#### 获取微信用户信息


**接口地址**:`/directory/user/getUserInfo`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{  "city": "",  "country": "",  "gender": 0,  "imageUrl": "",  "nickName": "",  "openId": "",  "province": ""}
```


**请求参数**:


| 参数名称             | 参数说明    | 请求类型 | 是否必须 | 数据类型    | schema      |
| -------------------- | ----------- | -------- | -------- | ----------- | ----------- |
| postUserDto          | postUserDto | body     | true     | PostUserDto | PostUserDto |
| &emsp;&emsp;city     | 城市        |          | false    | string      |             |
| &emsp;&emsp;country  | 国家        |          | false    | string      |             |
| &emsp;&emsp;gender   | 用户性别    |          | false    | integer     |             |
| &emsp;&emsp;imageUrl | 头像地址    |          | false    | string      |             |
| &emsp;&emsp;nickName | 用户名      |          | false    | string      |             |
| &emsp;&emsp;openId   | openID      |          | false    | string      |             |
| &emsp;&emsp;province | 省份        |          | false    | string      |             |


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


#### 通过用户openId获取用户留言


**接口地址**:`/directory/user/getUserMessageById`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| openId   | openId   | query    | true     | string   |        |


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


#### 用户上传图片


**接口地址**:`/directory/user/userAddImages`


**请求方式**:`POST`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| file     | file     | formData | true     | file     |        |
| openId   | openId   | query    | true     | string   |        |


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


#### 用户留言


**接口地址**:`/directory/user/userAddMessage`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称  | 参数说明  | 请求类型 | 是否必须 | 数据类型 | schema |
| --------- | --------- | -------- | -------- | -------- | ------ |
| message   | message   | query    | true     | string   |        |
| messageId | messageId | query    | false    | string   |        |
| openId    | openId    | query    | false    | string   |        |


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


#### 微信用户获取登录凭证


**接口地址**:`/directory/user/userLogin`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| code     | code     | query    | false    | string   |        |


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
