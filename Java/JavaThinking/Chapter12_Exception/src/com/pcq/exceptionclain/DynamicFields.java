package com.pcq.exceptionclain;

public class DynamicFields {
    private Object[][] fields;

    public DynamicFields(int initialSize) {
        this.fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++) {
            fields[i] = new Object[]{null, null};
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object[] obj : fields) {
            result.append(obj[0]);
            result.append(":");
            result.append(obj[1]);
            result.append("\n");
        }
        return result.toString();
    }

    private int hasField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if(id.equals(fields[i][0])) {
                return i;
            }
        }
        return -1;
    }

    private int getFieldNumber(String id) throws NoSuchFieldException {
        int fieldNumber = hasField(id);
        if(fieldNumber == -1) {
            throw new NoSuchFieldException();
        }
        return fieldNumber;
    }

    private int makeField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if(fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        }
        //如果当前数组已经满了，则增加一个空位
        Object[][] temp = new Object[fields.length + 1][2];
        for (int i = 0; i < fields.length; i++) {
            temp[i] = fields[i];
        }
        for (int i = fields.length; i < temp.length; i++) {
            temp[i] = new Object[]{null, null};
        }
        fields = temp;
        return makeField(id);
    }

    public Object getField(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }
    
}
