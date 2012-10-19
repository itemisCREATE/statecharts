/****************************************************************************
** Meta object code from reading C++ file 'TrafficLightRunner.h'
**
** Created: Fri Oct 19 15:33:20 2012
**      by: The Qt Meta Object Compiler version 63 (Qt 4.8.1)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../statemachine/TrafficLightRunner.h"
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'TrafficLightRunner.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 63
#error "This file was generated using the moc from 4.8.1. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
static const uint qt_meta_data_TrafficLightRunner[] = {

 // content:
       6,       // revision
       0,       // classname
       0,    0, // classinfo
       4,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       1,       // signalCount

 // signals: signature, parameters, type, tag, flags
      27,   20,   19,   19, 0x05,

 // slots: signature, parameters, type, tag, flags
      59,   19,   19,   19, 0x0a,
      70,   19,   19,   19, 0x0a,
      95,   19,   19,   19, 0x0a,

       0        // eod
};

static const char qt_meta_stringdata_TrafficLightRunner[] = {
    "TrafficLightRunner\0\0handle\0"
    "cycleDone(TrafficLightWaiting*)\0"
    "runCycle()\0raisePedestrianRequest()\0"
    "raiseOnOff()\0"
};

void TrafficLightRunner::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        Q_ASSERT(staticMetaObject.cast(_o));
        TrafficLightRunner *_t = static_cast<TrafficLightRunner *>(_o);
        switch (_id) {
        case 0: _t->cycleDone((*reinterpret_cast< TrafficLightWaiting*(*)>(_a[1]))); break;
        case 1: _t->runCycle(); break;
        case 2: _t->raisePedestrianRequest(); break;
        case 3: _t->raiseOnOff(); break;
        default: ;
        }
    }
}

const QMetaObjectExtraData TrafficLightRunner::staticMetaObjectExtraData = {
    0,  qt_static_metacall 
};

const QMetaObject TrafficLightRunner::staticMetaObject = {
    { &QObject::staticMetaObject, qt_meta_stringdata_TrafficLightRunner,
      qt_meta_data_TrafficLightRunner, &staticMetaObjectExtraData }
};

#ifdef Q_NO_DATA_RELOCATION
const QMetaObject &TrafficLightRunner::getStaticMetaObject() { return staticMetaObject; }
#endif //Q_NO_DATA_RELOCATION

const QMetaObject *TrafficLightRunner::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->metaObject : &staticMetaObject;
}

void *TrafficLightRunner::qt_metacast(const char *_clname)
{
    if (!_clname) return 0;
    if (!strcmp(_clname, qt_meta_stringdata_TrafficLightRunner))
        return static_cast<void*>(const_cast< TrafficLightRunner*>(this));
    return QObject::qt_metacast(_clname);
}

int TrafficLightRunner::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QObject::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 4)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 4;
    }
    return _id;
}

// SIGNAL 0
void TrafficLightRunner::cycleDone(TrafficLightWaiting * _t1)
{
    void *_a[] = { 0, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 0, _a);
}
QT_END_MOC_NAMESPACE
