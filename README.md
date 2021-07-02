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
| modifyTime  |   datetime   |          |  修改时间  |



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
| modifyTime  |   datetime   |          |  修改时间  |

### 3.科目表(tbl_branch)

|   字段名   |     类型     | 是否为空 |    备注    |
| :--------: | :----------: | :------: | :--------: |
|     id     | varchar(50)  | NOT NULL | 序号(UUID) |
|   branch   | varchar(50)  |          |    科目    |
| imagesUrl  | varchar(255) |          |  图片地址  |
|    type    |   tinyint    |          |  科目类型  |
| createTime |   datetime   |          |  创建时间  |
| modifyTime |   datetime   |          |  修改时间  |

### 4.属目表(tbl_genus)

|   字段名   |    类型     | 是否为空 |    备注    |
| :--------: | :---------: | :------: | :--------: |
|     id     | varchar(50) | NOT NULL | 序号(UUID) |
|   genus    | varchar(50) |          |    属目    |
|  branchId  | varchar(50) |          |   科目id   |
| createTime |  datetime   |          |  创建时间  |
| modifyTime |  datetime   |          |  修改时间  |

### 5.种类表(tbl_species)

|   字段名   |     类型     | 是否为空 |    备注    |
| :--------: | :----------: | :------: | :--------: |
|     id     | varchar(50)  | NOT NULL | 序号(UUID) |
|  species   | varchar(50)  |          |    种名    |
| imagesUrl  | varchar(255) |          |  图片地址  |
|  genusId   | varchar(50)  |          |   属类id   |
| createTime |   datetime   |          |  创建时间  |
| modifyTime |   datetime   |          |  修改时间  |

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
| modifyTime |   datetime   |          |   修改时间   |

-- ----------------------------

### 7.留言表(tbl_message)

|   字段名    |     类型     | 是否为空 |     备注     |
| :---------: | :----------: | :------: | :----------: |
|     id      | varchar(50)  | NOT NULL |  序号(UUID)  |
|   userId    | varchar(50)  |          |    用户id    |
|  imagesUrl  | varchar(255) |          | 留言图片地址 |
| userMessage | varchar(50)  |          |   留言信息   |
| createTime  |   datetime   |          |   创建时间   |
| modifyTime  |   datetime   |          |   修改时间   |

### 8.轮播图表(tbl_carousel)

|     字段名     |    类型     | 是否为空 |    备注    |
| :------------: | :---------: | :------: | :--------: |
|       id       | varchar(50) | NOT NULL | 序号(UUID) |
|  carouselUrl   | varchar(50) |          | 轮播图地址 |
| biologicalName | varchar(50) |          |  生物名称  |
|  biologicalId  | varchar(50) |          |   生物id   |
|   createTime   |  datetime   |          |  创建时间  |
|   modifyTime   |  datetime   |          |  修改时间  |

### 9.密码表（tbl_cipher）

| 字段名     | 类型         | 是否为空 | 备注       |
| :--------- | ------------ | -------- | ---------- |
| id         | varchar(50)  | NOT NULL | 序号(UUID) |
| openId     | varchar(50)  |          | 用户凭证   |
| cipher     | varchar(255) |          | 密码       |
| createTime | datetime     |          | 创建时间   |
| modifyTime | datetime     |          | 修改时间   |

### 10.权限表（tbl_permission）

| 字段名         | 类型        | 是否为空 | 备注       |
| -------------- | ----------- | -------- | ---------- |
| id             | varchar(50) | NOT NULL | 序号(UUID) |
| permissionName | varchar(50) |          | 权限名     |
| createTime     | datetime    |          | 创建时间   |
| modifyTime     | datetime    |          | 修改时间   |

### 11.用户权限表（tbl_user_permission）

| 字段名       | 类型        | 是否为空 | 备注       |
| ------------ | ----------- | -------- | ---------- |
| id           | varchar(50) | NOT NULL | 序号(UUID) |
| openId       | varchar(50) |          | 用户凭证   |
| permissionId | varchar(50) |          | 权限名id   |
| createTime   | datetime    |          | 创建时间   |
| modifyTime   | datetime    |          | 修改时间   |

## 接口文档


### admin-controller


#### 获取所有用户信息


**接口地址**:`/directory/admin/getALlUserIndo`


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


#### 管理员登录


**接口地址**:`/directory/admin/login`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| nickName | nickName | query    | true     | string   |        |
| cipher   | cipher   | query    | false    | string   |        |


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


#### 管理员修改密码


**接口地址**:`/directory/admin/putCipher`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称  | 参数说明  | 请求类型 | 是否必须 | 数据类型 | schema |
| --------- | --------- | -------- | -------- | -------- | ------ |
| cipher    | cipher    | query    | true     | string   |        |
| oldCipher | oldCipher | query    | true     | string   |        |
| openId    | openId    | query    | false    | string   |        |


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


#### 修改用户权限


**接口地址**:`/directory/admin/updateUserPermission`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称       | 参数说明       | 请求类型 | 是否必须 | 数据类型 | schema |
| -------------- | -------------- | -------- | -------- | -------- | ------ |
| openId         | openId         | query    | true     | string   |        |
| permissionName | permissionName | query    | false    | string   |        |


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


#### 删除动物


**接口地址**:`/directory/animals/deleteAnimalById`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| animalId | animalId | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 204    | No Content   |        |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |


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


#### 添加动物


**接口地址**:`/directory/animals/insertAnimal`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "address": "",
  "alias": "",
  "animalName": "",
  "branch": "",
  "description": "",
  "genus": "",
  "id": "",
  "imagesUrl": "",
  "modifyTime": "",
  "remarks": "",
  "species": ""
}
```


**请求参数**:


| 参数名称                | 参数说明       | 请求类型 | 是否必须 | 数据类型          | schema         |
| ----------------------- | -------------- | -------- | -------- | ----------------- | -------------- |
| postAnimalsDto          | postAnimalsDto | body     | true     | PostAnimalsDto    | PostAnimalsDto |
| &emsp;&emsp;address     | 分布区域       |          | false    | string            |                |
| &emsp;&emsp;alias       | 别名           |          | false    | string            |                |
| &emsp;&emsp;animalName  | 动物名称       |          | false    | string            |                |
| &emsp;&emsp;branch      | 科             |          | false    | string            |                |
| &emsp;&emsp;description | 描述信息       |          | false    | string            |                |
| &emsp;&emsp;genus       | 属             |          | false    | string            |                |
| &emsp;&emsp;id          |                |          | false    | string            |                |
| &emsp;&emsp;imagesUrl   | 图片地址       |          | false    | string            |                |
| &emsp;&emsp;modifyTime  |                |          | false    | string(date-time) |                |
| &emsp;&emsp;remarks     | 备注           |          | false    | string            |                |
| &emsp;&emsp;species     | 种             |          | false    | string            |                |


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


#### 修改动物


**接口地址**:`/directory/animals/putAnimal`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{  "address": "",  "alias": "",  "animalName": "",  "branch": "",  "description": "",  "genus": "",  "id": "",  "imagesUrl": "",  "modifyTime": "",  "remarks": "",  "species": ""}
```


**请求参数**:


| 参数名称                | 参数说明       | 请求类型 | 是否必须 | 数据类型          | schema         |
| ----------------------- | -------------- | -------- | -------- | ----------------- | -------------- |
| animalId                | animalId       | query    | true     | string            |                |
| postAnimalsDto          | postAnimalsDto | body     | true     | PostAnimalsDto    | PostAnimalsDto |
| &emsp;&emsp;address     | 分布区域       |          | false    | string            |                |
| &emsp;&emsp;alias       | 别名           |          | false    | string            |                |
| &emsp;&emsp;animalName  | 动物名称       |          | false    | string            |                |
| &emsp;&emsp;branch      | 科             |          | false    | string            |                |
| &emsp;&emsp;description | 描述信息       |          | false    | string            |                |
| &emsp;&emsp;genus       | 属             |          | false    | string            |                |
| &emsp;&emsp;id          |                |          | false    | string            |                |
| &emsp;&emsp;imagesUrl   | 图片地址       |          | false    | string            |                |
| &emsp;&emsp;modifyTime  |                |          | false    | string(date-time) |                |
| &emsp;&emsp;remarks     | 备注           |          | false    | string            |                |
| &emsp;&emsp;species     | 种             |          | false    | string            |                |


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


#### 查询所有动物


**接口地址**:`/directory/animals/searchAnimals`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称    | 参数说明    | 请求类型 | 是否必须 | 数据类型       | schema |
| ----------- | ----------- | -------- | -------- | -------------- | ------ |
| currentPage | currentPage | query    | true     | integer(int32) |        |


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


#### 删除科目


**接口地址**:`/directory/branch/deleteBranchById`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| branchId | branchId | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 204    | No Content   |        |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


#### 添加科目


**接口地址**:`/directory/branch/insertBranch`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称   | 参数说明   | 请求类型 | 是否必须 | 数据类型 | schema |
| ---------- | ---------- | -------- | -------- | -------- | ------ |
| branchName | branchName | query    | true     | string   |        |


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


#### 添加科目图片


**接口地址**:`/directory/branch/insertBranchImage`


**请求方式**:`POST`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称   | 参数说明   | 请求类型 | 是否必须 | 数据类型 | schema |
| ---------- | ---------- | -------- | -------- | -------- | ------ |
| branchName | branchName | query    | true     | string   |        |
| file       | file       | formData | true     | file     |        |


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


#### 修改科目信息


**接口地址**:`/directory/branch/putBranchById`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{  "branch": "",  "id": "",  "modifyTime": "",  "type": 0}
```


**请求参数**:


| 参数名称               | 参数说明      | 请求类型 | 是否必须 | 数据类型          | schema        |
| ---------------------- | ------------- | -------- | -------- | ----------------- | ------------- |
| postBranchDto          | postBranchDto | body     | true     | PostBranchDto     | PostBranchDto |
| &emsp;&emsp;branch     | 科目          |          | false    | string            |               |
| &emsp;&emsp;id         |               |          | false    | string            |               |
| &emsp;&emsp;modifyTime |               |          | false    | string(date-time) |               |
| &emsp;&emsp;type       | 科目类型地址  |          | false    | integer(int32)    |               |


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


#### 修改科目图片


**接口地址**:`/directory/branch/putBranchImage`


**请求方式**:`PUT`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| branchId | branchId | query    | true     | string   |        |
| file     | file     | formData | true     | file     |        |


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


#### 查询所有科目


**接口地址**:`/directory/branch/searchBranch`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称    | 参数说明    | 请求类型 | 是否必须 | 数据类型       | schema |
| ----------- | ----------- | -------- | -------- | -------------- | ------ |
| currentPage | currentPage | query    | true     | integer(int32) |        |


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


### carousel-controller


#### 删除轮播图


**接口地址**:`/directory/carousel/deleteCarousel`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称   | 参数说明   | 请求类型 | 是否必须 | 数据类型 | schema |
| ---------- | ---------- | -------- | -------- | -------- | ------ |
| carouselId | carouselId | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 204    | No Content   |        |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |


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


#### 添加轮播图


**接口地址**:`/directory/carousel/insertCarousel`


**请求方式**:`POST`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称       | 参数说明       | 请求类型 | 是否必须 | 数据类型 | schema |
| -------------- | -------------- | -------- | -------- | -------- | ------ |
| biologicalName | biologicalName | query    | true     | string   |        |
| file           | file           | formData | true     | file     |        |
| biologicalId   | biologicalId   | query    | false    | string   |        |


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


#### 修改轮播图


**接口地址**:`/directory/carousel/putCarousel`


**请求方式**:`PUT`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称   | 参数说明   | 请求类型 | 是否必须 | 数据类型 | schema |
| ---------- | ---------- | -------- | -------- | -------- | ------ |
| carouselId | carouselId | query    | true     | string   |        |
| file       | file       | formData | true     | file     |        |


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


### cipher-controller


#### 添加管理员权限密码


**接口地址**:`/directory/cipher/insertCipher`


**请求方式**:`POST`


**请求数据类型**:`application/json`


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


### genus-controller


#### 删除属目


**接口地址**:`/directory/genus/deleteGenus`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| genusId  | genusId  | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 204    | No Content   |        |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |


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


#### 修改属目


**接口地址**:`/directory/genus/putGenusById`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{  "branchId": "",  "genus": "",  "id": "",  "modifyTime": ""}
```


**请求参数**:


| 参数名称               | 参数说明     | 请求类型 | 是否必须 | 数据类型          | schema       |
| ---------------------- | ------------ | -------- | -------- | ----------------- | ------------ |
| postGenusDto           | postGenusDto | body     | true     | PostGenusDto      | PostGenusDto |
| &emsp;&emsp;branchId   | 科的id       |          | false    | string            |              |
| &emsp;&emsp;genus      | 属           |          | false    | string            |              |
| &emsp;&emsp;id         |              |          | false    | string            |              |
| &emsp;&emsp;modifyTime |              |          | false    | string(date-time) |              |


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


| 参数名称    | 参数说明    | 请求类型 | 是否必须 | 数据类型       | schema |
| ----------- | ----------- | -------- | -------- | -------------- | ------ |
| currentPage | currentPage | query    | true     | integer(int32) |        |


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


### message-controller


#### 删除用户留言


**接口地址**:`/directory/message/deleteUserMessages`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称  | 参数说明  | 请求类型 | 是否必须 | 数据类型 | schema |
| --------- | --------- | -------- | -------- | -------- | ------ |
| messageId | messageId | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 204    | No Content   |        |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |


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


#### 展示所有用户留言


**接口地址**:`/directory/message/getAllMessages`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称    | 参数说明    | 请求类型 | 是否必须 | 数据类型       | schema |
| ----------- | ----------- | -------- | -------- | -------------- | ------ |
| currentPage | currentPage | query    | true     | integer(int32) |        |


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


#### 留言总数


**接口地址**:`/directory/message/messagesCount`


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


### permission-controller


#### 添加权限


**接口地址**:`/directory/permission/addPermission`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| name     | name     | query    | false    | string   |        |


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


### plants-controller


#### 删除植物


**接口地址**:`/directory/plants/deletePlantById`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| plantId  | plantId  | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 204    | No Content   |        |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |


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


**请求示例**:


```javascript
{  "address": "",  "alias": "",  "branch": "",  "description": "",  "genus": "",  "id": "",  "imagesUrl": "",  "modifyTime": "",  "plantName": "",  "remarks": "",  "species": ""}
```


**请求参数**:


| 参数名称                | 参数说明      | 请求类型 | 是否必须 | 数据类型          | schema        |
| ----------------------- | ------------- | -------- | -------- | ----------------- | ------------- |
| postPlantsDto           | postPlantsDto | body     | true     | PostPlantsDto     | PostPlantsDto |
| &emsp;&emsp;address     | 分布区域      |          | false    | string            |               |
| &emsp;&emsp;alias       | 别名          |          | false    | string            |               |
| &emsp;&emsp;branch      | 科            |          | false    | string            |               |
| &emsp;&emsp;description | 描述信息      |          | false    | string            |               |
| &emsp;&emsp;genus       | 属            |          | false    | string            |               |
| &emsp;&emsp;id          |               |          | false    | string            |               |
| &emsp;&emsp;imagesUrl   | 图片地址      |          | false    | string            |               |
| &emsp;&emsp;modifyTime  |               |          | false    | string(date-time) |               |
| &emsp;&emsp;plantName   | 植物名称      |          | false    | string            |               |
| &emsp;&emsp;remarks     | 备注          |          | false    | string            |               |
| &emsp;&emsp;species     | 种            |          | false    | string            |               |


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


#### 修改植物


**接口地址**:`/directory/plants/putPlantById`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{  "address": "",  "alias": "",  "branch": "",  "description": "",  "genus": "",  "id": "",  "imagesUrl": "",  "modifyTime": "",  "plantName": "",  "remarks": "",  "species": ""}
```


**请求参数**:


| 参数名称                | 参数说明      | 请求类型 | 是否必须 | 数据类型          | schema        |
| ----------------------- | ------------- | -------- | -------- | ----------------- | ------------- |
| plantId                 | plantId       | query    | true     | string            |               |
| postPlantsDto           | postPlantsDto | body     | true     | PostPlantsDto     | PostPlantsDto |
| &emsp;&emsp;address     | 分布区域      |          | false    | string            |               |
| &emsp;&emsp;alias       | 别名          |          | false    | string            |               |
| &emsp;&emsp;branch      | 科            |          | false    | string            |               |
| &emsp;&emsp;description | 描述信息      |          | false    | string            |               |
| &emsp;&emsp;genus       | 属            |          | false    | string            |               |
| &emsp;&emsp;id          |               |          | false    | string            |               |
| &emsp;&emsp;imagesUrl   | 图片地址      |          | false    | string            |               |
| &emsp;&emsp;modifyTime  |               |          | false    | string(date-time) |               |
| &emsp;&emsp;plantName   | 植物名称      |          | false    | string            |               |
| &emsp;&emsp;remarks     | 备注          |          | false    | string            |               |
| &emsp;&emsp;species     | 种            |          | false    | string            |               |


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


| 参数名称    | 参数说明    | 请求类型 | 是否必须 | 数据类型       | schema |
| ----------- | ----------- | -------- | -------- | -------------- | ------ |
| currentPage | currentPage | query    | true     | integer(int32) |        |


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
```


### species-controller


#### 删除物种


**接口地址**:`/directory/species/deleteSpecies`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称  | 参数说明  | 请求类型 | 是否必须 | 数据类型 | schema |
| --------- | --------- | -------- | -------- | -------- | ------ |
| speciesId | speciesId | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | Result |
| 204    | No Content   |        |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |


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


**接口地址**:`/directory/species/insertImageById`


**请求方式**:`POST`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称  | 参数说明  | 请求类型 | 是否必须 | 数据类型 | schema |
| --------- | --------- | -------- | -------- | -------- | ------ |
| file      | file      | formData | true     | file     |        |
| speciesId | speciesId | query    | true     | string   |        |


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


#### 添加种类


**接口地址**:`/directory/species/insertSpecies`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{  "genusId": "",  "id": "",  "modifyTime": "",  "species": ""}
```


**请求参数**:


| 参数名称               | 参数说明       | 请求类型 | 是否必须 | 数据类型          | schema         |
| ---------------------- | -------------- | -------- | -------- | ----------------- | -------------- |
| postSpeciesDto         | postSpeciesDto | body     | true     | PostSpeciesDto    | PostSpeciesDto |
| &emsp;&emsp;genusId    | 属的id         |          | false    | string            |                |
| &emsp;&emsp;id         |                |          | false    | string            |                |
| &emsp;&emsp;modifyTime |                |          | false    | string(date-time) |                |
| &emsp;&emsp;species    | 种名           |          | false    | string            |                |


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


#### 查询所有种类


**接口地址**:`/directory/species/searchSpecies`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称    | 参数说明    | 请求类型 | 是否必须 | 数据类型       | schema |
| ----------- | ----------- | -------- | -------- | -------------- | ------ |
| currentPage | currentPage | query    | true     | integer(int32) |        |


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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
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
{	"details": "",	"info": "",	"message": {},	"path": "",	"status": 0,	"timestamp": ""}
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


| 参数名称             | 参数说明    | 请求类型 | 是否必须 | 数据类型       | schema      |
| -------------------- | ----------- | -------- | -------- | -------------- | ----------- |
| postUserDto          | postUserDto | body     | true     | PostUserDto    | PostUserDto |
| &emsp;&emsp;city     | 城市        |          | false    | string         |             |
| &emsp;&emsp;country  | 国家        |          | false    | string         |             |
| &emsp;&emsp;gender   | 用户性别    |          | false    | integer(int32) |             |
| &emsp;&emsp;imageUrl | 头像地址    |          | false    | string         |             |
| &emsp;&emsp;nickName | 用户名      |          | false    | string         |             |
| &emsp;&emsp;openId   | openID      |          | false    | string         |             |
| &emsp;&emsp;province | 省份        |          | false    | string         |             |


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
{
	"details": "",
	"info": "",
	"message": {},
	"path": "",
	"status": 0,
	"timestamp": ""
}
```

