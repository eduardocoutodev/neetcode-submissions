from typing import List


def get_index_of_seven(nums: List[int]) -> int:
    first_occurrence_index = -1
    for i, num in enumerate(nums):
        if num == 7:
            first_occurrence_index = i
            break
    
    return first_occurrence_index


def get_dist_between_sevens(nums: List[int]) -> int:
    first_occurrence_index = -1
    second_occurence_index = -1

    for i, num in enumerate(nums):
        if num != 7:
            continue

        if first_occurrence_index == -1:
            first_occurrence_index = i
            continue
        
        if second_occurence_index == -1:
            second_occurence_index = i
        
    return second_occurence_index - first_occurrence_index


# do not modify below this line
print(get_index_of_seven([1, 2, 3, 4, 5, 6, 7, 8, 9]))
print(get_index_of_seven([1, 2, 3, 4, 5, 6, 8, 9]))
print(get_index_of_seven([2, 4, 7, 5, 7, 8, 4, 2]))

print(get_dist_between_sevens([1, 2, 7, 4, 5, 6, 7, 8, 9]))
print(get_dist_between_sevens([2, 7, 7, 7, 8]))
print(get_dist_between_sevens([7, 4, 8, 4, 2, 7]))
