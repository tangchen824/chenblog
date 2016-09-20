package com.tc.freemarker;

import java.io.IOException;
import java.util.Map;

import com.tc.freemarker.OverrideDirective.TemplateDirectiveBodyOverrideWraper;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 父模板分块，让子模板继成.
 * <BR>
 *定义块，可以被子模板用@override指令覆盖显示,没有被override则显示自身的内容.
 */
public class BlockDirective implements TemplateDirectiveModel{
	/** block name */
	public static final String DIRECTIVE_NAME = "block";

	public void execute(Environment env,
            Map params, TemplateModel[] loopVars,
            TemplateDirectiveBody body) throws TemplateException, IOException {
		String name = DirectiveUtils.getRequiredParam(params, "name");
		TemplateDirectiveBodyOverrideWraper overrideBody = DirectiveUtils.getOverrideBody(env, name);
		if(overrideBody == null) {
			if(body != null) {
				body.render(env.getOut());
			}
		}else {
			DirectiveUtils.setTopBodyForParentBody(env, new TemplateDirectiveBodyOverrideWraper(
					body,env), overrideBody);
			overrideBody.render(env.getOut());
		}
	}	
}
