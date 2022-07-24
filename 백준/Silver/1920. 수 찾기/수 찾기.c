#include <stdio.h>
#include <stdlib.h>

int Make_Arr(int**a);
int binary_search(int key, int** arr, int low, int high);
int compare1(void *first, void *second);

int main(void) {
	int* arr = NULL;
	int* compare = NULL;
	int* result = NULL;
	int arr_length = 0;
	int compare_length = 0;
	int i = 0;

	/*숫자 입력 받음*/
	arr_length = Make_Arr(&arr);
	qsort(arr, arr_length, sizeof(int), compare1);
	/*비교할 숫자 입력 받음*/
	compare_length = Make_Arr(&compare);

	/*binary search로 비교*/
	for (i = 0; i < compare_length; i++) {
		printf("%d\n", binary_search(compare[i], &arr, 0, arr_length - 1));
	}

	return 0;
}


int Make_Arr(int**arr) {
	int arr_length = 0;
	int i = 0;
	scanf("%d", &arr_length);
	getchar();

	*arr = (int*)malloc(arr_length * 4);

	for (i = 0; i < arr_length; i++) {
		scanf("%d", &(*arr)[i]);
	}
	return arr_length;
}


int binary_search(int key, int** arr, int low, int high) {
	if (low <= high) {
		int mid = (low + high) / 2;
		if (key == (*arr)[mid]) {
			return 1;
		}
		else if (key > (*arr)[mid]) { //찾고자하는 값이 mid값보다 큰 경우
			return binary_search(key, arr, low, mid - 1);
		}
		else {//찾고자하는 값이 mid보다 작은 경우
			return binary_search(key, arr, mid + 1, high);
		}
	}
	return 0;
}

int compare1(void *first, void *second)
{
	if (*(int*)first < *(int*)second)
		return 1;
	else if (*(int*)first > *(int*)second)
		return -1;
	else
		return 0;
}