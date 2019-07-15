import distancecalculator as d
"""
get the Manhattan distance for every order

"""


def delivery_distance(delv_schedule):
    for key in delv_schedule:
        dval = d.dist(delv_schedule[key][0], delv_schedule[key][1])
        delv_schedule[key].append(dval)

    return delv_schedule

# delivery_schedule