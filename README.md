#   jackson
##  annotation

`@JsonAnyGetter`
---
    仅支持方法不支持属性,将map内的键值对提取出来作为json
   
`@JsonGetter`
---
    指定getter的属性名

`@JsonPropertyOrder`
---
    json序列化的顺序通过value指定特定顺序或者设置alphabetic = true

`@JsonRawValue`
---
    值作为原生json显示,而不是作为普通字符串
    
`@JsonValue`
---
    只能指定单个属性作为json的转换
    
`@JsonRootName`
---
    需要配置 objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE,true)
    
`@JsonSerialize`
---