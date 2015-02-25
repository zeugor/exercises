package org.elier.hp.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

public class TreeNodeTest {

	@Test
	public void findFirstCommonAncestor() {
		TreeNode a = new TreeNode(null); // root
		TreeNode b = new TreeNode(a);
		TreeNode c = new TreeNode(b);
		TreeNode d = new TreeNode(b);
		TreeNode e = new TreeNode(d);
		TreeNode f = new TreeNode(d);
		TreeNode g = new TreeNode(f);
		TreeNode h = new TreeNode(f);

		assertEquals(b, h.findFirstCommonAncestor(c));
		assertEquals(a, f.findFirstCommonAncestor(a));
		assertEquals(d, h.findFirstCommonAncestor(e));
		assertNotSame(f, g.findFirstCommonAncestor(c));
	}
}
