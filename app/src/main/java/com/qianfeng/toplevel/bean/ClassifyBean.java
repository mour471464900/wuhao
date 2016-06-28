package com.qianfeng.toplevel.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by my on 2016/6/28.
 */
public class ClassifyBean implements Serializable {

    /**
     * code : 200
     * data : {"candidates":[{"editable":true,"name":"海淘","id":129},{"editable":true,"name":"送女票","id":10},{"editable":true,"name":"创意生活","id":125},{"editable":true,"name":"送基友","id":26},{"editable":true,"name":"送爸妈","id":6},{"editable":true,"name":"送同事","id":17},{"editable":true,"name":"送宝贝","id":24},{"editable":true,"name":"设计感","id":127},{"editable":true,"name":"文艺风","id":14},{"editable":true,"name":"奇葩搞怪","id":126},{"editable":true,"name":"科技范","id":28},{"editable":true,"name":"萌萌哒","id":11}],"channels":[{"editable":false,"name":"精选","id":101},{"editable":true,"name":"海淘","id":129},{"editable":true,"name":"送女票","id":10},{"editable":true,"name":"创意生活","id":125},{"editable":true,"name":"送基友","id":26},{"editable":true,"name":"送爸妈","id":6},{"editable":true,"name":"送同事","id":17},{"editable":true,"name":"送宝贝","id":24},{"editable":true,"name":"设计感","id":127},{"editable":true,"name":"文艺风","id":14},{"editable":true,"name":"奇葩搞怪","id":126},{"editable":true,"name":"科技范","id":28},{"editable":true,"name":"萌萌哒","id":11}]}
     * message : OK
     */
    private int code;
    private DataEntity data;
    private String message;

    @Override
    public String toString() {
        return "ClassifyBean{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public DataEntity getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public class DataEntity {
        /**
         * candidates : [{"editable":true,"name":"海淘","id":129},{"editable":true,"name":"送女票","id":10},{"editable":true,"name":"创意生活","id":125},{"editable":true,"name":"送基友","id":26},{"editable":true,"name":"送爸妈","id":6},{"editable":true,"name":"送同事","id":17},{"editable":true,"name":"送宝贝","id":24},{"editable":true,"name":"设计感","id":127},{"editable":true,"name":"文艺风","id":14},{"editable":true,"name":"奇葩搞怪","id":126},{"editable":true,"name":"科技范","id":28},{"editable":true,"name":"萌萌哒","id":11}]
         * channels : [{"editable":false,"name":"精选","id":101},{"editable":true,"name":"海淘","id":129},{"editable":true,"name":"送女票","id":10},{"editable":true,"name":"创意生活","id":125},{"editable":true,"name":"送基友","id":26},{"editable":true,"name":"送爸妈","id":6},{"editable":true,"name":"送同事","id":17},{"editable":true,"name":"送宝贝","id":24},{"editable":true,"name":"设计感","id":127},{"editable":true,"name":"文艺风","id":14},{"editable":true,"name":"奇葩搞怪","id":126},{"editable":true,"name":"科技范","id":28},{"editable":true,"name":"萌萌哒","id":11}]
         */
        private List<CandidatesEntity> candidates;
        private List<ChannelsEntity> channels;

        @Override
        public String toString() {
            return "DataEntity{" +
                    "candidates=" + candidates +
                    ", channels=" + channels +
                    '}';
        }

        public void setCandidates(List<CandidatesEntity> candidates) {
            this.candidates = candidates;
        }

        public void setChannels(List<ChannelsEntity> channels) {
            this.channels = channels;
        }

        public List<CandidatesEntity> getCandidates() {
            return candidates;
        }

        public List<ChannelsEntity> getChannels() {
            return channels;
        }

        public class CandidatesEntity {
            /**
             * editable : true
             * name : 海淘
             * id : 129
             */
            private boolean editable;
            private String name;
            private int id;

            public void setEditable(boolean editable) {
                this.editable = editable;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setId(int id) {
                this.id = id;
            }

            public boolean isEditable() {
                return editable;
            }

            public String getName() {
                return name;
            }

            public int getId() {
                return id;
            }
        }

        public class ChannelsEntity {
            /**
             * editable : false
             * name : 精选
             * id : 101
             */
            private boolean editable;
            private String name;
            private int id;

            @Override
            public String toString() {
                return "ChannelsEntity{" +
                        "editable=" + editable +
                        ", name='" + name + '\'' +
                        ", id=" + id +
                        '}';
            }

            public void setEditable(boolean editable) {
                this.editable = editable;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setId(int id) {
                this.id = id;
            }

            public boolean isEditable() {
                return editable;
            }

            public String getName() {
                return name;
            }

            public int getId() {
                return id;
            }
        }
    }
}
