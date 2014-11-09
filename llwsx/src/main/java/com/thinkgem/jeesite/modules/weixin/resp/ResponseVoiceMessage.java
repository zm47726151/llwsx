/*
* 文 件 名:  VoiceMessage.java
* 版    权: 北京华通天达科技有限公司 Copyright,  All rights reserved
* 修 改 人:  wangjinguang
* 修改时间:  2013-12-19
*/
package com.thinkgem.jeesite.modules.weixin.resp;

/**
 *
 * @author  wangjinguang
 * @version  [1.0, 2013-12-19]
 */
public class ResponseVoiceMessage extends BaseResponseMessage{

	private static final long serialVersionUID = 1L;
	private String MediaId; 
    // 语音格式 
    private String Format; 
 
    public String getMediaId() { 
        return MediaId; 
    } 
 
    public void setMediaId(String mediaId) { 
        MediaId = mediaId; 
    } 
 
    public String getFormat() { 
        return Format; 
    } 
 
    public void setFormat(String format) { 
        Format = format; 
    } 
} 


