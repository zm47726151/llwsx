/*
* 文 件 名:  ComplexButton.java
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
public class ComplexButton extends Button {  
    private Button[] sub_button;  
  
    public Button[] getSub_button() {  
        return sub_button;  
    }  
  
    public void setSub_button(Button[] sub_button) {  
        this.sub_button = sub_button;  
    }  
}  
