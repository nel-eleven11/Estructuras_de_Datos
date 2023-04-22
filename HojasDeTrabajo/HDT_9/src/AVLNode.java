/*
 * Hdt 9
 * Nelson García Bravatti 22434
 *
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
public class AVLNode<E extends Comparable<E>> {

    E value;
    AVLNode<E> left;
    AVLNode<E> right;
    int height;

    public AVLNode(E value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.height = 1;
    }

    public AVLNode<E> add(E newValue) {
        int cmp = newValue.compareTo(value);
        if (cmp < 0) {
            left = (left == null) ? new AVLNode<>(newValue) : left.add(newValue);
        } else if (cmp > 0) {
            right = (right == null) ? new AVLNode<>(newValue) : right.add(newValue);
        } else {
            return this; // No duplicates allowed
        }
        updateHeight();
        return balance();
    }

    public boolean contains(E target) {
        int cmp = target.compareTo(value);
        if (cmp < 0) {
            return left != null && left.contains(target);
        } else if (cmp > 0) {
            return right != null && right.contains(target);
        } else {
            return true;
        }
    }

    public E get(E target) {
        int cmp = target.compareTo(value);
        if (cmp < 0) {
            return left == null ? null : left.get(target);
        } else if (cmp > 0) {
            return right == null ? null : right.get(target);
        } else {
            return value;
        }
    }

    public AVLNode<E> remove(E target) {
        int cmp = target.compareTo(value);
        if (cmp < 0) {
            left = left == null ? null : left.remove(target);
        } else if (cmp > 0) {
            right = right == null ? null : right.remove(target);
        } else {
            if (left == null && right == null) {
                return null;
            } else if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            } else {
                if (left.height > right.height) {
                    E maxValue = left.maxValue();
                    left = left.remove(maxValue);
                    value = maxValue;
                } else {
                    E minValue = right.minValue();
                    right = right.remove(minValue);
                    value = minValue;
                }
            }
        }
        updateHeight();
        return balance();
    }

    private E maxValue() {
        return right == null ? value : right.maxValue();
    }

    private E minValue() {
        return left == null ? value : left.minValue();
    }

    private void updateHeight() {
        height = 1 + Math.max(getHeight(left), getHeight(right));
    }

    private int balanceFactor() {
        return getHeight(left) - getHeight(right);
    }

    private AVLNode<E> balance() {
        if (balanceFactor() > 1) {
            if (left.balanceFactor() < 0) {
                left = left.rotateLeft();
            }
            return rotateRight();
        } else if (balanceFactor() < -1) {
            if (right.balanceFactor() > 0) {
                right = right.rotateRight();
            }
            return rotateLeft();
        }
        return this;
    }

    private AVLNode<E> rotateLeft() {
        AVLNode<E> newRoot = right;
        right = newRoot.left;
        newRoot.left = this;
        updateHeight();
        newRoot.updateHeight();
        return newRoot;
    }

    private AVLNode<E> rotateRight() {
        AVLNode<E> newRoot = left;
        left = newRoot.right;
        newRoot.right = this;
        updateHeight();
        newRoot.updateHeight();
        return newRoot;
    }

    private static int getHeight(AVLNode<?> node) {
        return node == null ? 0 : node.height;
    }

    public Iterator<E> iterator() {
        Queue<AVLNode<E>> queue = new LinkedList<>();
        queue.offer(this);
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public E next() {
                AVLNode<E> current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                return current.value;
            }
        };
    }

    public String treeString(int depth) {
        StringBuilder sb = new StringBuilder();
        if (right != null) {
            sb.append(right.treeString(depth + 1));
        }
        for (int i = 0; i < depth; i++) {
            sb.append("  ");
        }
        sb.append(value).append("\n");
        if (left != null) {
            sb.append(left.treeString(depth + 1));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (left != null) {
            sb.append(left.toString());
        }
        sb.append(value.toString());
        if (right != null) {
            sb.append(right.toString());
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + (left == null ? 0 : left.hashCode());
        result = 31 * result + (right == null ? 0 : right.hashCode());
        return result;
    }
}
