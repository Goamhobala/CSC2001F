public class BinarySearchTree<T extends Comparable>{
    class BinarySearchTreeNode<T>{
        T data;
        BinarySearchTreeNode left;
        BinarySearchTreeNode right;
        public BinarySearchTreeNode(T data, BinarySearchTreeNode left, BinarySearchTreeNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    
        public BinarySearchTreeNode(T data){
            this(data, null, null);
        }
    
    }

    BinarySearchTreeNode<T> root;
    
    public BinarySearchTree(BinarySearchTreeNode<T> root){
        this.root = root;
    }

    public BinarySearchTree(){
        this(null);
    }

    public BinarySearchTreeNode search(){
        
    }


}

