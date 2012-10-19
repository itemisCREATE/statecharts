/****************************************************************************
** Meta object code from reading C++ file 'org_yakindu_sct_examples_c_trafficlight.h'
**
** Created: Fri Oct 19 15:33:21 2012
**      by: The Qt Meta Object Compiler version 63 (Qt 4.8.1)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../org_yakindu_sct_examples_c_trafficlight.h"
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'org_yakindu_sct_examples_c_trafficlight.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 63
#error "This file was generated using the moc from 4.8.1. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
static const uint qt_meta_data_org_yakindu_sct_examples_c_trafficlight[] = {

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
      48,   41,   40,   40, 0x0a,

       0        // eod
};

static const char qt_meta_stringdata_org_yakindu_sct_examples_c_trafficlight[] = {
    "org_yakindu_sct_examples_c_trafficlight\0"
    "\0handle\0update(TrafficLightWaiting*)\0"
};

void org_yakindu_sct_examples_c_trafficlight::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        Q_ASSERT(staticMetaObject.cast(_o));
        org_yakindu_sct_examples_c_trafficlight *_t = static_cast<org_yakindu_sct_examples_c_trafficlight *>(_o);
        switch (_id) {
        case 0: _t->update((*reinterpret_cast< TrafficLightWaiting*(*)>(_a[1]))); break;
        default: ;
        }
    }
}

const QMetaObjectExtraData org_yakindu_sct_examples_c_trafficlight::staticMetaObjectExtraData = {
    0,  qt_static_metacall 
};

const QMetaObject org_yakindu_sct_examples_c_trafficlight::staticMetaObject = {
    { &QMainWindow::staticMetaObject, qt_meta_stringdata_org_yakindu_sct_examples_c_trafficlight,
      qt_meta_data_org_yakindu_sct_examples_c_trafficlight, &staticMetaObjectExtraData }
};

#ifdef Q_NO_DATA_RELOCATION
const QMetaObject &org_yakindu_sct_examples_c_trafficlight::getStaticMetaObject() { return staticMetaObject; }
#endif //Q_NO_DATA_RELOCATION

const QMetaObject *org_yakindu_sct_examples_c_trafficlight::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->metaObject : &staticMetaObject;
}

void *org_yakindu_sct_examples_c_trafficlight::qt_metacast(const char *_clname)
{
    if (!_clname) return 0;
    if (!strcmp(_clname, qt_meta_stringdata_org_yakindu_sct_examples_c_trafficlight))
        return static_cast<void*>(const_cast< org_yakindu_sct_examples_c_trafficlight*>(this));
    return QMainWindow::qt_metacast(_clname);
}

int org_yakindu_sct_examples_c_trafficlight::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QMainWindow::qt_metacall(_c, _id, _a);
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
