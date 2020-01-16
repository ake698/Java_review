package com.nowcoder.TreeDemo;

/**
 * 二叉树  二叉排列树
 *  先序遍历  核心思想：
 *              访问节点
 *              遍历节点的左子树
 *              遍历节点的右子树
 *
 * 中序遍历  核心思想：
 *              中序遍历节点的左子树
 *              访问节点
 *              中序遍历节点的右子树
 *
 *
 * 后续遍历    核心思想：
 *                  后序遍历节点的左子树
 *                  后序遍历节点的右子树
 *                  访问节点
 */
public class Tree {

    //根
    private Node root;

    public void insert(int keyData,int otherData){
        Node newNode = new Node(keyData,otherData);

        if(root == null){//无节点
            root = newNode;
        }else{
            Node current = root;
            Node parent; //当插入值为最值的时候 使用
            //小于根节点数 往左边找 反之
            while(true){
                parent = current;
                if(keyData < current.getKeyData()){
                    current = current.getLeftNode();
                    if(current==null){
                        parent.setLeftNode(newNode);
                        return;
                    }
                }else{
                    current = current.getRightNode();
                    if(current == null){
                        parent.setRightNode(newNode);
                        return;
                    }
                }
            }

        }
    }

    public Node find(int keyData){
        Node current = root;
        while (current.getKeyData() != keyData){
            if(keyData < current.getKeyData()){
                current = current.getLeftNode();
            }else{
                current = current.getRightNode();
            }
            if(current == null){
                return null;
            }
        }
        return current;

    }


    /**
     * 删除节点
     * @param keyData
     */
    public void delete(int keyData){
        if(root==null){
            return;
        }
        //找到节点
        Node target = find(keyData);
        if(target==null)return;
        //找到他的父节点
        Node parent = findParent(target);
        //叶子节点 无左节点和右节点
        if(target.getLeftNode()==null&&target.getRightNode()==null){
            if(parent.getLeftNode()==target){
                //要删除的节点是父节点的左节点
                parent.setLeftNode(null);
            }else{
                //右子节点
                parent.setRightNode(null);
            }
        }else if(target.getLeftNode()!=null&&target.getRightNode()!=null){
            //要删除的节点有俩个子节点
            //删除右子树中值最小的节点 并获取到改节点的值
            Node min = deleteMin(target.getRightNode());
            //替换目标节点中的值
            target.setKeyData(min.getKeyData());
            target.setOtherData(min.getOtherData());

        }else{
            //要删除的节点有一个左子节点或者一个右子节点
            if(target.getLeftNode()!=null){
                //有左子节点 无右子节点
                if(parent.getRightNode()==target){
                    //如果要删除的子节点是其父节点的右子节点
                    parent.setRightNode(target.getLeftNode());
                }else{
                    parent.setLeftNode(target.getLeftNode());
                }
            }else{
                //有右子节点 无左子节点
                if(parent.getLeftNode()==target){
                    //如果要删除的子节点是其父节点的左子节点
                    parent.setLeftNode(target.getRightNode());
                }else{
                    parent.setRightNode(target.getRightNode());
                }
            }
        }
    }

    //删除一棵树中最小的节点
    private Node deleteMin(Node node) {
        Node target = node;
        while(target.getLeftNode()!=null){
            //循环找左边子节点
            target=node.getLeftNode();
        }
        //删除最小的节点
        delete(target.getKeyData());
        //如果这个节点有子节点
//        if()
        return target;
    }

    /**
     * 搜索父节点
     * @param current
     * @return
     */
    public Node findParent(Node current){
        Node parent = root;
        if(current == null){
            return null;
        }
        while(parent!=current){
            if(parent.getLeftNode()==current)return parent;
            if(parent.getRightNode()==current)return parent;
            if(parent.getKeyData() > current.getKeyData()){
                parent = parent.getLeftNode();
            }else{
                parent = parent.getRightNode();
            }
        }
        return parent;
    }

    public void change(int keyData,int newOtherData){
        Node current = find(keyData);
        if(current==null){
            return;
        }
        current.setOtherData(newOtherData);
    }


    //先序遍历
    public void preOrder(Node node){
        if(node != null){
            node.display();
            preOrder(node.getLeftNode());
            preOrder(node.getRightNode());
        }
    }

    //中序遍历
    public void inOrder(Node node){
        if(node !=null){
            inOrder(node.getLeftNode());
            node.display();
            inOrder(node.getRightNode());
        }
    }


    //后序遍历
    public void endOrder(Node node){
        if(node !=null){
            endOrder(node.getLeftNode());
            endOrder(node.getRightNode());
            node.display();
        }
    }

    public Node getRoot(){
        return root;
    }


}
