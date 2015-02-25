package org.elier.hp.tree;

import java.util.ArrayList;

public class TreeNode {
	private TreeNode parent;

	TreeNode(TreeNode parent) {
		this.parent = parent;
	}

	TreeNode findFirstCommonAncestor(TreeNode other) {
		ArrayList<TreeNode> myAncestorList = new ArrayList<TreeNode>();
		ArrayList<TreeNode> otherAncestorList = new ArrayList<TreeNode>();

		TreeNode ancestor = this;
		while(ancestor != null) {
			myAncestorList.add(ancestor);
			ancestor = ancestor.parent;
		}

		ancestor = other;
		while(ancestor != null) {
			otherAncestorList.add(ancestor);
			ancestor = ancestor.parent;
		}

		TreeNode node = null;
		int index = 0;
		while((index < myAncestorList.size()
				&& index < otherAncestorList.size()
				&& myAncestorList.get(myAncestorList.size() - 1 - index).equals(otherAncestorList.get(otherAncestorList.size() - 1 - index)))) {
			node = myAncestorList.get(myAncestorList.size() - 1 - index);
			index++;
		}
		return node;
	}

}
