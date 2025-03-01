# Base Common Library

## 项目简介
Base Common Library 是一个基于 Spring Boot 的通用支持库，提供了一套完整的企业级应用开发基础设施。该项目集成了主流的开发框架和工具，旨在简化开发流程，提高开发效率。

## 特性
- 🚀 基于 Spring Boot 2.7.4，提供完整的Web应用支持
- 🔒 集成 Sa-Token 实现权限认证
- 💾 支持 MySQL 数据库，集成 MyBatis-Plus 实现高效数据访问
- 📦 Redis 缓存支持，提供完整的缓存操作封装
- 📊 Excel 导入导出支持
- 🔄 数据库版本控制
- 🛠 丰富的工具类库支持

## 技术栈

### 核心框架
- **[Spring Boot](https://spring.io/projects/spring-boot)** (v2.7.4)
  - spring-boot-starter-web：Web应用基础框架
  - spring-boot-starter-aop：面向切面编程支持
  - spring-boot-starter-validation：数据校验支持
  - spring-boot-starter-mail：邮件发送功能
  - spring-boot-starter-test：单元测试支持
  - spring-boot-starter-actuator：应用监控和管理

### 数据库相关
- **[MySQL](https://www.mysql.com/)** (v8.0.28)：数据库驱动
- **[MyBatis-Plus](https://baomidou.com/)** (v3.5.7)
  - mybatis-plus-boot-starter：MyBatis增强框架
  - mybatis-plus-generator：代码生成器
- **[Flyway](https://flywaydb.org/)** (v8.2.0)：数据库版本管理工具

### 缓存中间件
- **[Redis](https://redis.io/)**：数据缓存（spring-boot-starter-data-redis）
  - 支持字符串、哈希、列表、集合等数据结构
  - 提供完整的缓存操作封装
  - 支持过期时间设置

### 安全框架
- **[Sa-Token](https://sa-token.cc/)** (v1.38.0)：权限认证框架
  - 支持登录认证、权限认证、单点登录
  - 提供注解鉴权、路由拦截鉴权等多种鉴权方式

### 模板引擎
- **[Velocity](https://velocity.apache.org/)** (v2.3)：代码生成模板引擎
- **[FreeMarker](https://freemarker.apache.org/)** (v2.3.34)：模板引擎

### 工具库
- **[Hutool](https://hutool.cn/)** (v5.8.28)：Java工具集
- **[Lombok](https://projectlombok.org/)** (v1.18.32)：Java代码生成工具
- **[FastJson](https://github.com/alibaba/fastjson)** (v2.0.46)：JSON处理工具
- **[MapStruct](https://mapstruct.org/)** (v1.6.2)：对象映射工具
- **[FastExcel](https://github.com/dhatim/fastexcel)** (v1.1.0)：Excel处理工具

## 主要功能特性
1. **Web应用支持**
   - RESTful API 支持
   - 统一响应处理
   - 全局异常处理

2. **AOP切面编程**
   - 方法执行时间监控
   - 日志记录
   - 数据权限控制

3. **数据验证**
   - 参数校验
   - 数据格式验证
   - 自定义验证注解

4. **邮件发送**
   - 支持文本邮件
   - 支持HTML邮件
   - 支持附件发送

5. **数据库操作**
   - MyBatis-Plus 增强功能
   - 代码生成器
   - 分页查询支持

6. **缓存支持**
   - Redis 缓存封装
   - LRU本地缓存实现
   - 多级缓存支持

7. **权限认证**
   - 用户认证
   - 角色授权
   - 权限控制

8. **Excel处理**
   - Excel导入导出
   - 模板导出
   - 大数据量处理

9. **应用监控**
   - 性能监控
   - 健康检查
   - 运行状态监控

10. **对象映射**
    - DTO与实体类转换
    - 自定义映射规则
    - 集合映射支持

11. **数据库版本控制**
    - 数据库脚本管理
    - 版本升级
    - 回滚支持

## 快速开始

### 环境要求
- JDK 1.8+
- Maven 3.6+
- MySQL 8.0+
- Redis 5.0+

### 开发环境
- JDK版本：1.8
- 编码方式：UTF-8
- 构建工具：[Maven](https://maven.apache.org/)

### 项目导入
1. 克隆项目到本地
```bash
git clone https://github.com/your-username/base-common.git
```

2. 导入到IDE中（推荐使用 IntelliJ IDEA）

3. 配置数据库
   - 创建数据库：base_common
   - 修改 `application.properties` 中的数据库连接信息

4. 配置Redis
   - 修改 `application.properties` 中的Redis连接信息

5. 执行数据库脚本
   - 项目启动时会自动执行 `resources/db/migration` 目录下的SQL脚本

### 项目结构
```
base-common
├── src/main/java/                    # Java源代码目录
│   ├── com/example/common/
│   │   ├── config/                   # 配置类
│   │   ├── controller/               # 控制器
│   │   ├── service/                  # 服务层
│   │   ├── mapper/                   # MyBatis接口
│   │   ├── model/                    # 数据模型
│   │   └── util/                     # 工具类
├── src/main/resources/               # 资源文件目录
│   ├── mapper/                       # MyBatis映射文件
│   ├── db/migration/                 # 数据库脚本
│   └── application.properties        # 应用配置文件
└── src/test/                         # 测试代码目录
```

### 使用示例

1. **添加依赖**
```xml
<dependency>
    <groupId>com.example</groupId>
    <artifactId>base-common</artifactId>
    <version>1.0.0</version>
</dependency>
```

2. **配置文件示例**
```properties
# 数据库配置
spring.datasource.url=jdbc:mysql://localhost:3306/base_common
spring.datasource.username=root
spring.datasource.password=password

# Redis配置
spring.redis.host=localhost
spring.redis.port=6379
```

3. **代码示例**
```java
@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Base Common!";
    }
}
```

## 常见问题
1. **启动失败**
   - 检查数据库连接配置是否正确
   - 确保Redis服务已启动
   - 查看日志获取详细错误信息

2. **缓存问题**
   - 确保Redis配置正确
   - 检查缓存key是否正确
   - 查看Redis连接状态

## 贡献指南
1. Fork 本仓库
2. 创建新的分支：`git checkout -b feature/your-feature`
3. 提交更改：`git commit -am 'Add new feature'`
4. 推送到分支：`git push origin feature/your-feature`
5. 提交 Pull Request

## 版本历史
- v1.0.0 (2024-01)
  - 初始版本发布
  - 基础功能实现

## 开源协议
本项目使用 [MIT 许可证](LICENSE)。

## 联系方式
- 项目地址：[GitHub](https://github.com/your-username/base-common)
- 问题反馈：[Issues](https://github.com/your-username/base-common/issues)
