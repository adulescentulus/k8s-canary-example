apiVersion: apps/v1
kind: Deployment
metadata:
  name: frontend-BRANCH_NAME
  labels:
    app: frontend
    branch: BRANCH_NAME
spec:
  replicas: 1
  selector:
    matchLabels:
      app: frontend
  template:
    metadata:
      labels:
        app: frontend
    spec:
      containers:
        - name: frontend
          image: gcr.io/GOOGLE_CLOUD_PROJECT/frontend:COMMIT_SHA
          ports:
            - containerPort: 8080
          resources:
            requests:
              cpu: 100m
              memory: 128M
            limits:
              memory: 128M
          env:
            - name: CONTAINER_HOST
              valueFrom:
                fieldRef:
                  fieldPath: status.podIP
            - name: IMAGE_VERSION
              value: COMMIT_SHA
            - name: DE_NETWORKCHALLENGE_HOWTO_CANARY_FRONTEND_RECTANGLESERVICE_MP_REST_URL
              value: http://rectangle:8080
            - name: DE_NETWORKCHALLENGE_HOWTO_CANARY_FRONTEND_CIRCLESERVICE_MP_REST_URL
              value: http://circle:8080
---
kind: Service
apiVersion: v1
metadata:
  name: frontend
spec:
  selector:
    app: frontend
  ports:
    - protocol: TCP
      port: 80
      targetPort: 8080
  type: LoadBalancer