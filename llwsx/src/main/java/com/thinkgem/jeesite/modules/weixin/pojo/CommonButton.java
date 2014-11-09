/*
* 文 件 名:  CommonButton.java
* 版    权: 北京华通天达科技有限公司 Copyright,  All rights reserved
* 修 改 人:  wangjinguang
* 修改时间:  2013-12-20
*/
package com.thinkgem.jeesite.modules.weixin.pojo;

/**
 *
 * @author  wangjinguang
 * @version  [1.0, 2013-12-20]
 */
public class CommonButton extends Button {  
    private String type;  
    private String key;  
  
    public String getType() {  
        return type;  
    }  
  
    public void setType(String type) {  
        this.type = type;  
    }  
  
    public String getKey() {  
        return key;  
    }  
  
    public void setKey(String key) {  
        this.key = key;  
    }  
}
