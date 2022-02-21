package com.cisco.assignment.graph;

public class GraphNode implements GNode {
	
    private String nodeName;


    private GNode[] children;
	
    
    GraphNode(String name){
    	this.nodeName = name;
    }
    
	
    public void setChildren(GNode[] child) {
    	
    	this.children = new GNode[child.length];
    	
    	for(int i=0;i< child.length;i++) {
    		this.children[i] = child[i];
    	}
    	
    }

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.nodeName;
	}

	@Override
	public GNode[] getChildren() {
		
		if(this.children == null) {
			return new GNode[0];
		}else {
			return this.children;
		}
	}

}
