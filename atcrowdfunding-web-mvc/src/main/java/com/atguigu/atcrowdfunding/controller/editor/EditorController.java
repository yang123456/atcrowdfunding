package com.atguigu.atcrowdfunding.controller.editor;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.atcrowdfunding.bean.Result;
import com.atguigu.atcrowdfunding.entity.Editor;
import com.atguigu.atcrowdfunding.service.EditorService;
import com.atguigu.atcrowdfunding.utils.ResultUtil;

/**
 * Created on 2018/3/2 0002.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Controller
@RequestMapping("/editorWeb")
public class EditorController {

	@Autowired
	private EditorService editorService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Result saveEditor(Editor editor) {
		System.out.println(editor.toString());
		editorService.save(editor);
		return ResultUtil.success();
	}

	/**
	 * 预览
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	// @GetMapping("/preview/{id}")
	@RequestMapping("/preview/{id}")
	public ModelAndView preview(@PathVariable(value = "id") int id, Map map) {
		Editor editor = editorService.findOne(id);
		map.put("editor", editor);
		return new ModelAndView("markdown/preview", map);
	}

	/**
	 * 编辑
	 * @param id
	 * @param map
	 * @return
	 */
//    @GetMapping("/edit/{id}")
	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable(value = "id") int id, Map map) {

		Editor editor = editorService.findOne(id);
		map.put("editor", editor);
		return new ModelAndView("markdown/simple", map);
	}
}
