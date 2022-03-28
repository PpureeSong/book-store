from sqlalchemy.ext.declarative import declarative_base 
from sqlalchemy import Column, String, Integer, event, Float, Boolean
from datetime import datetime

import util
from DeliveryReady import DeliveryReady
from Accepted import Accepted
from Rejected import Rejected

Base = declarative_base()

class StoreOrder(Base):
    __tablename__ = 'StoreOrder_table'
    id = Column(Integer, primary_key=True)
    bookId = Column(String(50))
    preference = Column(String(50))
    orderId = Column(Integer)
    status = Column(String(50))

    def __init__(self):
        self.id = None
        self.bookId = None
        self.preference = None
        self.orderId = None
        self.status = None

@event.listens_for(StoreOrder, 'after_insert')
def PostPersist(mapper, connection, target):
    event = DeliveryReady()
    event = util.AutoBinding(target, event)

    event.Publish()
    
    event = Accepted()
    event = util.AutoBinding(target, event)

    event.Publish()
    
    event = Rejected()
    event = util.AutoBinding(target, event)

    event.Publish()
    

    

