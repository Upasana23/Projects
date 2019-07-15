from datetime import datetime
from datetime import date
import datetime as dt

"""
NPS Calculation

"""


def nps(deliv, pcount, dcount):
    totalc = len(deliv)
    for key in deliv:
        duration = datetime.combine(date.min, deliv[key][5]) - datetime.combine(date.min, deliv[key][2])
        if duration <= dt.timedelta(hours=1, minutes=0, seconds=0):
            pcount += 1
        if duration > dt.timedelta(hours=4, minutes=0, seconds=0):
            dcount += 1
    npscal = (pcount / totalc * 100) - (dcount / totalc * 100)

    return round(npscal)
