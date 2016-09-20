/**
 * 通用工具JS
 * 
 * @author tc
 * @createDate 2015-03-10
 */
common = (function() {
	//兼容域名模式不用上下文，basePath取域名，本机或IP取ip:port/context/
	var location = (window.location + '').split('/');
	var basePath = location[0] + '//' + location[2] + '/' + location[3] + '/';
	if (location[2] == "deardealwith.applinzi.com"
			|| location[2] == "1.deardealwith.applinzi.com") {
		basePath = location[0] + '//' + location[2] + '/';
	}
	var _menu = function(url) {
		_load();
		window.location.href = basePath + url;
	};
	var _post = function(param, url, successdo) {
		_load();
		$.ajax({
			type : "POST",
			url : basePath + url,
			data : JSON.stringify(param),
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				var datastring = data.toString();
				if (datastring.indexOf("<html") > -1) {
					_unload();
					$("body").html(datastring);
				} else {
					_unload();
					successdo(data);
				}
			},
			error : function(e) {
				_unload();
				common.alert("出错", e);
			}
		});
	};

	var _confirm = function(title, message, Yesdo, Nodo) {
		$.confirm({
			'title' : title,
			'message' : message,
			'buttons' : {
				'是' : {
					'class' : 'blue',
					'action' : Yesdo
				},
				'否' : {
					'class' : 'gray',
					'action' : Nodo
				}
			}
		});
	};
	var _alert = function(title, message) {
		$.confirm({
			'title' : title,
			'message' : message,
			'buttons' : {
				'确定' : {
					'class' : 'blue',
					'action' : function() {
						return;
					}
				}
			}
		});
	};
	var _Mconfirm = function(title, message, Yesdo, Nodo) {
		$.confirm({
			'title' : title,
			'message' : message,
			'buttons' : {
				'修改' : {
					'class' : 'blue',
					'action' : Yesdo
				},
				'删除' : {
					'class' : 'gray',
					'action' : Nodo
				}
			}
		});
	};
	/**
	 * 遮罩层工具,专用于接口调用遮罩
	 * 
	 * @author tc
	 * @createDate 2015-04-03
	 */
	var _jq = null;
	function _load() {
		_jq = _render();
	}
	;
	function _unload() {
		if (_jq !== null)
			_jq.remove();
	}
	;
	function _render() {
		var _div = $("<div></div>").addClass("mas").appendTo("body");
		var _css = _getCss();
		_div.css(_css).fadeIn();
		return _div;
	}
	;
	function _getCss() {
		var height = document.documentElement.scrollHeight;
		if (document.documentElement.clientHeight > height)
			height = document.documentElement.clientHeight;
		var css = {
			padding : 0 + "px",
			margin : 0 + "px",
			background : "#555",
			position : "absolute",
			display : "none",
			top : 0 + "px",
			left : 0 + "px",
			width : document.documentElement.clientWidth + "px",
			height : height + "px",
			zIndex : 999,
			opacity : 0.6
		};
		return css;
	}
	;

	return {
		Mconfirm : _Mconfirm,
		alert : _alert,
		basePath : basePath,
		confirm : _confirm,
		post : _post,
		menu : _menu
	};
})();

/**
 * 遮罩层工具
 * 
 * @author tc
 * @createDate 2015-03-10
 */
var mask = function() {
	var jq = null;
	function load() {
		mask.jq = _render();
	}
	;
	function unload() {
		if (mask.jq !== null)
			mask.jq.remove();
	}
	;
	function _render() {
		var _div = $("<div></div>").addClass("mask").appendTo("body");
		var _css = _getCss();
		_div.css(_css).fadeIn();
		return _div;
	}
	;
	function _getCss() {
		var height = document.documentElement.scrollHeight;
		if (document.documentElement.clientHeight > height)
			height = document.documentElement.clientHeight;
		var css = {
			padding : 0 + "px",
			margin : 0 + "px",
			background : "#555",
			position : "absolute",
			display : "none",
			top : 0 + "px",
			left : 0 + "px",
			width : document.documentElement.clientWidth + "px",
			height : height + "px",
			zIndex : 99,
			opacity : 0.6
		};
		return css;
	}
	;
	return {
		jq : jq,
		load : load,
		unload : unload
	};
}();

/**
 * 初始化
 */
$(function() {
	/**
	 * 工具
	 */
	Array.prototype.indexOf = function(val) {
		for ( var i = 0; i < this.length; i++) {
			if (this[i] == val)
				return i;
		}
		return -1;
	};
	Array.prototype.remove = function(val) {
		var index = this.indexOf(val);
		if (index > -1) {
			this.splice(index, 1);
		}
	};
	/**
	 * 界面高度
	 */
	var total = document.documentElement.clientHeight;

	if (document.getElementById("header") != null)
		document.getElementById("header").style.height = total * 0.05 + "px";
	if (document.getElementById("content") != null)
		document.getElementById("content").style.height = total * 0.85 + "px";
	// if(document.getElementById("contents")!=null)
	// document.getElementById("contents").style.height=(total-232)+"px";
	if (document.getElementById("footer") != null)
		document.getElementById("footer").style.height = total * 0.1 + "px";
});


// Ajax 文件下载
jQuery.download = function(url, data, method) {
	// 获取url和data
	if (url && data) {
		// data 是 string 或者 array/object
		data = typeof data == 'string' ? data : jQuery.param(data);
		// 把参数组装成 form的 input
		var inputs = '';
		jQuery.each(data.split('&'), function() {
			var pair = this.split('=');
			inputs += '<input type="hidden" name="' + pair[0] + '" value="'
					+ pair[1] + '" />';
		});
		// request发送请求
		jQuery(
				'<form action="' + url + '" method="' + (method || 'post')
						+ '">' + inputs + '</form>').appendTo('body').submit()
				.remove();
	}
	;
};