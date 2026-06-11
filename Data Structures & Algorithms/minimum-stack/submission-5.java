
// Implementation with Array, but push may take O(n) run time
class MinStack {
    int[] arr;
    int[] minArr;
    int index;

    public MinStack() {
        arr = new int[10];
        minArr = new int[10];
        index = 0;
    }

    public void push(int val) {
        arr[index] = val;

        if (index == 0 || val < minArr[index - 1]) {
            minArr[index] = val;
        } else {
            minArr[index] = minArr[index - 1];
        }

        index++;
        // Copying elements takes O(n) time complexity
        if (index >= arr.length) {
            int[] newArr = new int[arr.length * 2];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;

            int[] newMinArr = new int[minArr.length * 2];
            System.arraycopy(minArr, 0, newMinArr, 0, minArr.length);
            minArr = newMinArr;
        }
    }

    public void pop() {
        index--;
    }

    public int top() {
        return arr[index - 1];
    }

    public int getMin() {
        return minArr[index - 1];
    }
}