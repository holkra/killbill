/*
 * Copyright 2010-2013 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.billing.payment.api;

import java.util.List;

public interface PaymentMethodPlugin {


    /**
     *
     * @return the id from the plugin
     */
    public String getExternalPaymentMethodId();

    /**
     *
     * @return whether plugin sees that PM as being the default
     */
    public boolean isDefaultPaymentMethod();

    /**
     *
     * @return the list of key/value pair set by the plugin
     */
    public List<PaymentMethodKVInfo> getProperties();

    /**
     *
     * @param key the key for which to get the value
     * @return the value associated with the key
     */
    public String getValueString(String key);

    /**
     *
     * @return the payment method type name if applicable
     */
    public String getType();

    /**
     *
     * @return the credit card name if applicable
     */
    public String getCCName();

    /**
     *
     * @return the credit card type if applicable
     */
    public String getCCType();

    /**
     *
     * @return the credit card expiration month
     */
    public String getCCExpirationMonth();

    /**
     *
     * @return the credit card expiration year
     */
    public String getCCExpirationYear();

    /**
     *
     * @return the credit card last 4 numbers
     */
    public String getCCLast4();

    /**
     *
     * @return the address line 1
     */
    public String getAddress1();

    /**
     *
     * @return the address line 2
     */
    public String getAddress2();

    /**
     *
     * @return the city
     */
    public String getCity();

    /**
     *
     * @return the state
     */
    public String getState();

    /**
     *
     * @return the zip
     */
    public String getZip();

    /**
     *
     * @return the country
     */
    public String getCountry();


    public class PaymentMethodKVInfo {

        private final String key;
        private final Object value;
        private final Boolean isUpdatable;

        public PaymentMethodKVInfo(final String key, final Object value, final Boolean isUpdatable) {
            this.key = key;
            this.value = value;
            this.isUpdatable = isUpdatable;
        }

        public String getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public Boolean getIsUpdatable() {
            return isUpdatable;
        }



        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("PaymentMethodKVInfo");
            sb.append("{key='").append(key).append('\'');
            sb.append(", value=").append(value);
            sb.append(", isUpdatable=").append(isUpdatable);
            sb.append('}');
            return sb.toString();
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            final PaymentMethodKVInfo that = (PaymentMethodKVInfo) o;

            if (isUpdatable != null ? !isUpdatable.equals(that.isUpdatable) : that.isUpdatable != null) {
                return false;
            }
            if (key != null ? !key.equals(that.key) : that.key != null) {
                return false;
            }
            if (value != null ? !value.equals(that.value) : that.value != null) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            result = 31 * result + (isUpdatable != null ? isUpdatable.hashCode() : 0);
            return result;
        }
    }
}
