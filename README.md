#IDEA搭建SSH开发环境
<h3>本平台基于SSH开发</h3>
<h4>已知存在的问题:</h4>
<ol>
    <li>Struts2 动态方法调用失效
        <ul><li>struts2 2.5+出于安全考虑需在action上添加global-allowed-methods属性</li></ul>
    </li>
    <li>log4j 尚未配置实现</li>
    <li>xml文件中"/>"与"xx/>"结尾效果一样，无参数需求可以直接添加</li>
    <li>在配置连接池/hibernate主配置的url中jdbc.jdbcUrl=jdbc:mysql:///ssh与jdbc.jdbcUrl=jdbc:mysql://localhost:3306/ssh 等价</li>
    <li>idea自动生成的约束标签需要改一条:xmlns:tx="http://www.springframework.org/schema/tx"<br>同时,xsi:schemaLocation 加上：http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd 删除原来的cache</li>
</ol>