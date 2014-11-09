/*
* 文 件 名:  MenuManager.java
* 版    权: 北京华通天达科技有限公司 Copyright,  All rights reserved
* 修 改 人:  wangjinguang
* 修改时间:  2013-12-20
*/
package com.thinkgem.jeesite.modules.weixin.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thinkgem.jeesite.modules.weixin.pojo.AccessToken;
import com.thinkgem.jeesite.modules.weixin.pojo.Button;
import com.thinkgem.jeesite.modules.weixin.pojo.ComplexButton;
import com.thinkgem.jeesite.modules.weixin.pojo.Menu;
import com.thinkgem.jeesite.modules.weixin.pojo.ViewButton;
import com.thinkgem.jeesite.modules.weixin.util.WeixinUtil;

/**
 *
 * @author  wangjinguang
 * @version  [1.0, 2013-12-20]
 */
public class MenuManager {  
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);  
  
    public static void main(String[] args) {  
        // 第三方用户唯一凭证  
        String appId = "wx1088aea4f7f703a5";  
        // 第三方用户唯一凭证密钥  
        String appSecret = "365c90011706fd639a8a8534af3a9463";
  
        // 调用接口获取access_token  
        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);  
  
        if (null != at) {  
//        	WeixinUtil.sendMessage(at.getToken());
//        	WeixinUtil.getUser(at.getToken());
            // 调用接口创建菜单  
//        	WeixinUtil.deleteMenu(at.getToken());;
            int result = WeixinUtil.createMenu(getMenu(), at.getToken()); 
//            
//  
//            // 判断菜单创建结果  
//            if (0 == result)  
//                log.info("菜单创建成功！");  
//            else  
//                log.info("菜单创建失败，错误码：" + result);  
        }  
    }  
  
    /** 
     * 组装菜单数据 
     *  
     * @return 
     */  
    private static Menu getMenu() {  
//        CommonButton btn11 = new CommonButton();  
//        btn11.setName("天气预报");  
//        btn11.setType("click");  
//        btn11.setKey("11");  
//  
//        CommonButton btn12 = new CommonButton();  
//        btn12.setName("公交查询");  
//        btn12.setType("click");  
//        btn12.setKey("12");  
//  
//        CommonButton btn13 = new CommonButton();  
//        btn13.setName("周边搜索");  
//        btn13.setType("click");  
//        btn13.setKey("13");  
//  
//        CommonButton btn14 = new CommonButton();  
//        btn14.setName("历史上的今天");  
//        btn14.setType("click");  
//        btn14.setKey("14");  
//          
//        CommonButton btn15 = new CommonButton();  
//        btn15.setName("电影排行榜");  
//        btn15.setType("click");  
//        btn15.setKey("32");  
//  
//        CommonButton btn21 = new CommonButton();  
//        btn21.setName("歌曲点播");  
//        btn21.setType("click");  
//        btn21.setKey("21");  
//  
//        CommonButton btn22 = new CommonButton();  
//        btn22.setName("经典游戏");  
//        btn22.setType("click");  
//        btn22.setKey("22");  
//  
//        CommonButton btn23 = new CommonButton();  
//        btn23.setName("美女电台");  
//        btn23.setType("click");  
//        btn23.setKey("23");  
//  
//        CommonButton btn24 = new CommonButton();  
//        btn24.setName("人脸识别");  
//        btn24.setType("click");  
//        btn24.setKey("24");  
//  
//        CommonButton btn25 = new CommonButton();  
//        btn25.setName("聊天唠嗑");  
//        btn25.setType("click");  
//        btn25.setKey("25");  
//  
//        CommonButton btn31 = new CommonButton();  
//        btn31.setName("Q友圈");  
//        btn31.setType("click");  
//        btn31.setKey("31");  
//  
//        CommonButton btn33 = new CommonButton();  
//        btn33.setName("幽默笑话");  
//        btn33.setType("click");  
//        btn33.setKey("33");  
//          
//        CommonButton btn34 = new CommonButton();  
//        btn34.setName("用户反馈");  
//        btn34.setType("click");  
//        btn34.setKey("34");  
//          
//        CommonButton btn35 = new CommonButton();  
//        btn35.setName("关于我们");  
//        btn35.setType("click");  
//        btn35.setKey("35");  
          
        ViewButton btn1 = new ViewButton();  
        btn1.setName("进入微理财");  
        btn1.setType("view");  
        btn1.setUrl("http://www.welicai.com");  
        
        ViewButton btn2 = new ViewButton();  
        btn2.setName("我的账户");  
        btn2.setType("view");  
        btn2.setUrl("http://www.welicai.com");
  
//        ComplexButton mainBtn1 = new ComplexButton();  
//        mainBtn1.setName("生活助手");  
//        mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13, btn14, btn15 });  
  
//        ComplexButton mainBtn2 = new ComplexButton();  
//        mainBtn2.setName("休闲驿站");  
//        mainBtn2.setSub_button(new Button[] { btn21, btn22, btn23, btn24, btn25 });  
  
        ViewButton btn31 = new ViewButton();  
        btn31.setName("我要理财");  
        btn31.setType("view");  
        btn31.setUrl("http://www.welicai.com");
        ViewButton btn32 = new ViewButton();  
        btn32.setName("如何使用");  
        btn32.setType("view");  
        btn32.setUrl("http://www.welicai.com");
        
        ViewButton btn33 = new ViewButton();
        btn33.setName("关于平台");
        btn33.setType("view");  
        btn33.setUrl("http://www.welicai.com");
        
        
        
        ComplexButton mainBtn3 = new ComplexButton();  
        mainBtn3.setName("帮助");  
        mainBtn3.setSub_button(new Button[] { btn31,btn32, btn33 });
//        mainBtn3.setSub_button(new Button[] { btn31, btn33, btn34, btn35, btn32 });  
  
        /** 
         * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br> 
         *  
         * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br> 
         * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br> 
         * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 }); 
         */  
        Menu menu = new Menu();  
        menu.setButton(new Button[] { btn1, btn2, mainBtn3 });  
  
        return menu;  
    }  
}  
