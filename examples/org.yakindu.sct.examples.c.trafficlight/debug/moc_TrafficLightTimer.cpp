/****************************************************************************
** Meta object code from reading C++ file 'TrafficLightTimer.h'
**
** Created: Fri Oct 19 14:59:24 2012
**      by: The Qt Meta Object Compiler version 63 (Qt 4.8.1)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../statemachine/TrafficLightTimer.h"
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'TrafficLightTimer.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 63
#error "This file was generated using the moc from 4.8.1. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
static const uint qt_meta_data_TrafficLightTimer[] = {

 // content:
       6,       // revision
       0,       // classname
       0,    0, // classinfo
       1,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       0,       // signalCount

 // slots: signature, parameters, type, tag, flags
      24,   19,   18,   18, 0x0a,

       0        // eod
};

static const char qt_meta_stringdata_TrafficLightTimer[] = {
    "TrafficLightTimer\0\0evid\0"
    "raiseTimeEvent(sc_eventid)\0"
};

void TrafficLightTimer::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        Q_ASSERT(staticMetaObject.cast(_o));
        TrafficLightTimer *_t = static_cast<TrafficLightTimer *>(_o);
        switch (_id) {
        case 0: _t->raiseTimeEvent((*reinterpret_cast< sc_eventid(*)>(_a[1]))); break;
        default: ;
        }
    }
}

const QMetaObjectExtraData TrafficLightTimer::staticMetaObjectExtraData = {
    0,  qt_static_metacall 
};

const QMetaObject TrafficLightTimer::staticMetaObject = {
    { &QObject::staticMetaObject, qt_meta_stringdata_TrafficLightTimer,
      qt_meta_data_TrafficLightTimer, &staticMetaObjectExtraData }
};

#ifdef Q_NO_DATA_RELOCATION
const QMetaObject &TrafficLightTimer::getStaticMetaObject() { return staticMetaObject; }
#endif //Q_NO_DATA_RELOCATION

const QMetaObject *TrafficLightTimer::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->metaObject : &staticMetaObject;
}

void *TrafficLightTimer::qt_metacast(const char *_clname)
{
    if (!_clname) return 0;
    if (!strcmp(_clname, qt_meta_stringdata_TrafficLightTimer))
        return static_cast<void*>(const_cast< TrafficLightTimer*>(this));
    return QObject::qt_metacast(_clname);
}

int TrafficLightTimer::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QObject::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 1)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 1;
    }
    return _id;
}
QT_END_MOC_NAMESPACE
