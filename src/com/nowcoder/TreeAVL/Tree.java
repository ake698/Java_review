package com.nowcoder.TreeAVL;

/**
 * 二叉树 平衡二叉树
 */
public class Tree {

    //根
    private Node root;

    //返回节点的高度
    public int height(Node node){
        return Math.max(node.getLeftNode()==null?0:height(node.getLeftNode()),node.getRightNode()==null?0:height(node.getRightNode()))+1;
    }



    //p安端右子树的高度


    public void insert(int keyData, int otherData) {
        Node newNode = new Node(keyData, otherData);
        if (root == null) {//无节点
            root = newNode;
        } else {
            insertNode(newNode,root);
        }
    }

    public void insertNode(Node node,Node current){
        //小于根节点数 往左边找 反之
        if (node.getKeyData() < current.getKeyData()) {
            if (current.getLeftNode()== null) {
                current.setLeftNode(node);
                return;
            }
            insertNode(node,current.getLeftNode());
        } else {
            if (current.getRightNode() == null) {
                current.setRightNode(node);
                return;
            }
            insertNode(node,current.getRightNode());
        }
        //判断树是否平衡
        if(height(current.getLeftNode())-height(current.getRightNode())>=2){
            //左边高度高于右边 需要右旋转

            //双旋转 当左子节点左边高度小于右边高度的时候
            if(height(current.getLeftNode().getLeftNode())<height(current.getLeftNode().getRightNode())){
                leftRotate(current.getLeftNode());
//                rightRotate(current);
            }
            rightRotate(current);  //单独旋转

        }
        if(height(current.getLeftNode())-height(current.getRightNode())<=-2){

            //当右边子节点的右高度小于左高度 进行右边旋转
            if(height(current.getRightNode().getRightNode())<height(current.getRightNode().getLeftNode())){
                    rightRotate(current.getRightNode());
            }
            leftRotate(current);//左旋转
        }

    }

    /**
     * 左旋转
     * @param node
     */
    private void leftRotate(Node node) {
        Node newLeft = new Node(node.getKeyData(),node.getOtherData());
        newLeft.setLeftNode(node.getLeftNode());

        newLeft.setRightNode(node.getRightNode().getLeftNode());

        node.setKeyData(node.getRightNode().getKeyData());
        node.setOtherData(node.getRightNode().getOtherData());

        node.setRightNode(node.getRightNode().getRightNode());
        node.setLeftNode(newLeft);
    }

    /**
     * 右旋转树
     */
    private void rightRotate(Node node) {
        //1.创建一个新的节点 值等于当前节点的值
        //2.把新节点的右子树设置为当前节点的右子树
        Node newRight = new Node(node.getKeyData(),node.getOtherData());
        newRight.setRightNode(node.getRightNode());
        //3.把新节点的左子树设置为当前节点的左子树的右子树
        newRight.setLeftNode(node.getLeftNode().getRightNode());
        //4.把当前节点的值换成左子节点的值
        node.setKeyData(node.getLeftNode().getKeyData());
        node.setOtherData(node.getLeftNode().getOtherData());
        //5.把当前节点的左子树设置为左子树的左子树
        node.setLeftNode(node.getLeftNode().getLeftNode());
        //6.把当前节点的右子树设置为新节点
        node.setRightNode(newRight);

    }

    public Node find(int keyData) {
        Node current = root;
        while (current.getKeyData() != keyData) {
            if (keyData < current.getKeyData()) {
                current = current.getLeftNode();
            } else {
                current = current.getRightNode();
            }
            if (current == null) {
                return null;
            }
        }
        return current;

    }


    /**
     * 删除节点
     *
     * @param keyData
     */
    public void delete(int keyData) {
        if (root == null) {
            return;
        }
        //找到节点
        Node target = find(keyData);
        if (target == null) return;
        //找到他的父节点
        Node parent = findParent(target);
        //叶子节点 无左节点和右节点
        if (target.getLeftNode() == null && target.getRightNode() == null) {
            if (parent.getLeftNode() == target) {
                //要删除的节点是父节点的左节点
                parent.setLeftNode(null);
            } else {
                //右子节点
                parent.setRightNode(null);
            }
        } else if (target.getLeftNode() != null && target.getRightNode() != null) {
            //要删除的节点有俩个子节点
            //删除右子树中值最小的节点 并获取到改节点的值
            Node min = deleteMin(target.getRightNode());
            //替换目标节点中的值
            target.setKeyData(min.getKeyData());
            target.setOtherData(min.getOtherData());
        } else {
            //要删除的节点有一个左子节点或者一个右子节点
            if (target.getLeftNode() != null) {
                //有左子节点 无右子节点
                if (parent.getRightNode() == target) {
                    //如果要删除的子节点是其父节点的右子节点
                    parent.setRightNode(target.getLeftNode());
                } else {
                    parent.setLeftNode(target.getLeftNode());
                }
            } else {
                //有右子节点 无左子节点
                if (parent.getLeftNode() == target) {
                    //如果要删除的子节点是其父节点的左子节点
                    parent.setLeftNode(target.getRightNode());
                } else {
                    parent.setRightNode(target.getRightNode());
                }
            }
        }

    }

    //删除一棵树中最小的节点
    private Node deleteMin(Node node) {
        Node target = node;
        while (target.getLeftNode() != null) {
            //循环找左边子节点
            target = node.getLeftNode();
        }
        //删除最小的节点
        delete(target.getKeyData());
        return target;
    }

    /**
     * 搜索父节点
     *
     * @param current
     * @return
     */
    public Node findParent(Node current) {
        Node parent = root;
        if (current == null) {
            return null;
        }
        while (parent != current) {
            if (parent.getLeftNode() == current) return parent;
            if (parent.getRightNode() == current) return parent;
            if (parent.getKeyData() > current.getKeyData()) {
                parent = parent.getLeftNode();
            } else {
                parent = parent.getRightNode();
            }
        }
        return parent;
    }

    public void change(int keyData, int newOtherData) {
        Node current = find(keyData);
        if (current == null) {
            return;
        }
        current.setOtherData(newOtherData);
    }


    //先序遍历
    public void preOrder(Node node) {
        if (node != null) {
            node.display();
            preOrder(node.getLeftNode());
            preOrder(node.getRightNode());
        }
    }

    //中序遍历
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeftNode());
            node.display();
            inOrder(node.getRightNode());
        }
    }


    //后序遍历
    public void endOrder(Node node) {
        if (node != null) {
            endOrder(node.getLeftNode());
            endOrder(node.getRightNode());
            node.display();
        }
    }

    public Node getRoot() {
        return root;
    }


}
