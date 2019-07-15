import datetime

"""
Converting the input file into a dictionary with values y, x, order placement time, one hour after delivery time

"""

def convert_input(delivery):
    for key in delivery:
        s = delivery[key]
        s = s.split(" ")
        i = 0
        lister = []
        p = s[0]
        t = list(p)
        for k in range(len(t)):
            if not t[k].isdigit():
                temp = 0
                if t[k] == "S":
                    iter = k + 1
                    while iter < len(t) and t[iter].isdigit():
                        temp = temp * 10 + int(t[iter])
                        iter += 1
                    lister.append(-(temp))
                elif t[k] == "N":
                    iter = k + 1
                    while iter < len(t) and t[iter].isdigit():
                        temp = temp * 10 + int(t[iter])
                        iter += 1
                    lister.append(temp)
                elif t[k] == "E":
                    iter = k + 1
                    while iter < len(t) and t[iter].isdigit():
                        temp = temp * 10 + int(t[iter])
                        iter += 1
                    lister.append(temp)
                elif t[k] == "W":
                    iter = k + 1
                    while iter < len(t) and t[iter].isdigit():
                        temp = temp * 10 + int(t[iter])
                        iter += 1
                    lister.append(-(temp))
                else:
                    continue
        k = s[1]
        k = k.split(":")
        lister.append(datetime.time(int(k[0]), int(k[1]), int(k[2])))
        lister.append(datetime.time(int(k[0]) + 1, int(k[1]), int(k[2])))
        #print(lister)
        delivery[key] = lister

    return delivery

