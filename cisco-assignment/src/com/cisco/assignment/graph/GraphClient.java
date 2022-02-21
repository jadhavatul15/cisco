package com.cisco.assignment.graph;

import java.util.List;

/*
 * 
 * Initial Graph 
 * 
 *          E
 *        /
 *       B 
 *      / \ F
 *     /  
 *    /      G
 *   /     / 
 *   A - c --- H  
 *    \     \
 *     \      I  
 *      \
 *       D -- J 
 *   	
 */
  

public class GraphClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		GraphNode nodeA = new GraphNode("A");
		GraphNode nodeB = new GraphNode("B");
		GraphNode nodeC = new GraphNode("C");
		GraphNode nodeD = new GraphNode("D");
		GraphNode nodeE = new GraphNode("E");
		GraphNode nodeF = new GraphNode("F");
		GraphNode nodeG = new GraphNode("G");
		GraphNode nodeH = new GraphNode("H");
		GraphNode nodeI = new GraphNode("I");
		GraphNode nodeJ = new GraphNode("J");
		
		
		nodeA.setChildren(new GNode[] {nodeB,nodeC,nodeD});
		nodeB.setChildren(new GNode[] {nodeE,nodeF});
		nodeC.setChildren(new GNode[] {nodeG,nodeH,nodeI});
		nodeD.setChildren(new GNode[] {nodeJ});
		
		Graph graph = new Graph();
		
		List<GNode> listNodes = graph.walkGraph(nodeA);
		
		
		System.out.println("Graph node start with A: ");
		for(int i=0;i< listNodes.size();i++) {
			System.out.print(listNodes.get(i).getName()+ " ");
		} 
		
		 listNodes = graph.walkGraph(nodeB);
		System.out.println("\nGraph node start with B: ");
		for(int i=0;i< listNodes.size();i++) {
			System.out.print(listNodes.get(i).getName()+ " ");
		}
		
	 
   

		System.out.println("\nAll possible path from Node A: ");
		List<List<GNode>> allPaths = graph.paths(nodeA);
		
		for(List<GNode> path : allPaths) {
			
			path.forEach(node -> System.out.print(node.getName()+ " "));
			System.out.println();
		}
		
		System.out.println("\nAll possible path from Node C: ");
		 allPaths = graph.paths(nodeC);
		
		for(List<GNode> path : allPaths) {
			
			path.forEach(node -> System.out.print(node.getName()+ " "));
			System.out.println();
		}
		

	}

}
