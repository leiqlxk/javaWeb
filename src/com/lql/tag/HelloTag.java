package com.lql.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Title: HelloTag <br>
 * ProjectName: javaWeb <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2020/11/12 17:04 <br>
 */
public class HelloTag extends TagSupport {

    //当jsp解析器遇到hello标签的结束标志时，调用此方法
    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().print("Hello");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }
}
