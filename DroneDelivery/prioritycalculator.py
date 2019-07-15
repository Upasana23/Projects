import datetime as dt

"""
Calculates Priority of Orders

"""


def calc_priority(delivery_schedule):

    priority = []
    d_start_time = dt.time(6, 0, 0)

    for key in delivery_schedule:

        if dt.datetime.combine(dt.date(1, 1, 1), delivery_schedule[key][2]).time() >= d_start_time:
            delivery_time = (dt.datetime.combine(dt.date(1, 1, 1), delivery_schedule[key][2]) + dt.timedelta(
                minutes=delivery_schedule[key][4])).time()
        else:

            delivery_time = (dt.datetime.combine(dt.date(1, 1, 1), d_start_time) + dt.timedelta(
                minutes=delivery_schedule[key][4])).time()

        if delivery_time <= delivery_schedule[key][3]:
            priority.append(key)

    for key in delivery_schedule:
        if dt.datetime.combine(dt.date(1, 1, 1), delivery_schedule[key][2]).time() >= d_start_time:
            delivery_time = (dt.datetime.combine(dt.date(1, 1, 1), delivery_schedule[key][2]) + dt.timedelta(
                minutes=delivery_schedule[key][4])).time()
        else:

            delivery_time = (dt.datetime.combine(dt.date(1, 1, 1), d_start_time) + dt.timedelta(
                minutes=delivery_schedule[key][4])).time()

        if dt.time(1, 0, 0) < delivery_time <= dt.time(2, 0, 0):
            priority.append(key)

    for key in delivery_schedule:
        if key not in priority:
            priority.append(key)

    return priority

