import pandas

dataframe = pandas.read_csv("sample.csv")

print(dataframe)
print(dataframe["Usernames"])
print(dataframe.sort_values('Usernames'))