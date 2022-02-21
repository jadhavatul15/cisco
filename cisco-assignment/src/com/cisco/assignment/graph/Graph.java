package com.cisco.assignment.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	List<GNode> currPath = new ArrayList<>();

	/**
	 * Return all possible path reachable from node 
	 * @param node
	 * @return
	 */
	public List<List<GNode>> paths(GNode node) {

		List<List<GNode>> allPaths = new ArrayList<>();
		Stack<GNode> stack = new Stack<>();

		getAllPaths(node, stack, allPaths);
		return allPaths;

	}

	/**
	 * Recursive function to find all paths 
	 * @param node
	 * @param stack
	 * @param allPaths
	 */
	private void getAllPaths(GNode node, Stack<GNode> stack, List<List<GNode>> allPaths) {

		stack.push(node);
		currPath.add(node);

		while (!stack.isEmpty()) {

			GNode currNode = stack.peek();

			GNode[] children = currNode.getChildren();

			if (children.length == 0) {
				allPaths.add(new ArrayList<GNode>(currPath));

			} else {

				for (GNode childNode : children) {

					getAllPaths(childNode, stack, allPaths);
					stack.pop();
					currPath.remove(currPath.size() - 1);
				}

			}
			
			break;
		}

	}

	/**
	 * Return every node in the graph
	 * @param node
	 * @return
	 */
	public List<GNode> walkGraph(GNode node) {

		ArrayList<GNode> allNodes = new ArrayList<>();

		Queue<GNode> queue = new LinkedList<>();

		allNodes.add(node);

		queue.addAll(Arrays.asList(node.getChildren()));

		while (!queue.isEmpty()) {

			GNode currNode = queue.poll();
			allNodes.add(currNode);
			queue.addAll(Arrays.asList(currNode.getChildren()));

		}

		return allNodes;

	}
}
