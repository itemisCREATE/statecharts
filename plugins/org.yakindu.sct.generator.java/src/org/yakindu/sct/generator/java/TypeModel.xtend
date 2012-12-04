package org.yakindu.sct.generator.java

import org.yakindu.base.types.Type

class TypeModel {
	
	def boolean isVoid(Type type) {
		type == null || type.name == null || type.name == "void"
	}
	
	def String getJavaType(Type type) {
		
		if (type == null) {
			return "void"
		}
		
		switch (type.name) {
			case "real" : "double"
			case "integer" : "int"
			case "boolean" : "boolean"
			case "string" : "String"
			case "void" : "void"
			default : "//"+this
		};
	}
		
def String getJavaClassType(Type type) {
		switch (type.name) {
		case "real" : "Double"
		case "integer" : "Integer"
		case "boolean" : "Boolean"
		case "string" : "String"
		case "void" : "Void"
		case null : "Void"
		default : "//"+type
		};
	}
		
def String getInitialValue(Type type) {
		switch (type.name) {
		case "real" : "0D"
		case "integer" : "0"
		case "boolean" : "false"
		case "string" : "\"\""
		case "void" : "null"
		default : ""
		};
	}
}