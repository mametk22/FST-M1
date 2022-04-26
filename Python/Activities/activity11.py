fruit_shop = {
    "mango": 30,
    "banana": 150,
    "orange": 80,
    "peaches": 55,
    "apple": 50
}

check = input("What are you looking for? ").lower()

if(check in fruit_shop):
    print("Yes, this is available")
else:
    print("No, this is not available")