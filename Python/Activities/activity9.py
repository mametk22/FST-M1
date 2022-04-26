listOne = [14, 21, 28, 10, 18]
listTwo = [23, 53, 84, 66, 12]
print("First List ", listOne)
print("Second List ", listTwo)

thirdList = []

for num in listOne:
    if (num % 2 != 0):
        thirdList.append(num)


for num in listTwo:
    if (num % 2 == 0):
        thirdList.append(num)


print("result List is:")
print(thirdList)